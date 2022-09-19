package com.task.rewardpoints.controller;

import com.task.rewardpoints.dto.Reward;
import com.task.rewardpoints.dto.RewardResponse;
import com.task.rewardpoints.exception.CustomerNotFoundException;
import com.task.rewardpoints.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.annotation.Resource;
import java.time.Month;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class TransactionControllerTest {
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    private RewardResponse rewardResponse;

    @BeforeEach
    public void setUp() {
        rewardResponse = new RewardResponse(
                Arrays.asList(
                        new Reward(Month.JULY, 20.9),
                        new Reward(Month.AUGUST, 20.9),
                        new Reward(Month.SEPTEMBER, 20.9)),
                300.00,
                1L);
    }

    @Test
    public void getRewardsById_withValidCustomerId_successful() throws Exception {
        given(transactionService.getRewards(anyLong())).willReturn(rewardResponse);
        ResultActions resultActions = mockMvc.perform(get("/api/transactions/rewards?customerId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.total", is(rewardResponse.total)))
                .andExpect(jsonPath("$.customerId", is(Long.valueOf(rewardResponse.customerId).intValue())));

        for (int i = 0; i < rewardResponse.rewards.size(); i++) {
            resultActions.andExpect(jsonPath(String.format("$.rewards.[%d].month", i), is(rewardResponse.rewards.get(i).month.toString())));
            resultActions.andExpect(jsonPath(String.format("$.rewards.[%d].reward", i), is(rewardResponse.rewards.get(i).reward)));
        }
    }

    @Test
    public void getRewardsById_withInvalidCustomerId_returnErrorResponse() throws Exception {
        final long CUSTOMER_ID = 1L;
        given(transactionService.getRewards(anyLong())).willThrow(CustomerNotFoundException.class);
        mockMvc.perform(get(String.format("/api/transactions/rewards?customerId=%d", CUSTOMER_ID)))
                .andExpect(status().isNotFound())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CustomerNotFoundException));
    }
}
