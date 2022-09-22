package com.task.rewardpoints.service;

import com.task.rewardpoints.dao.TransactionRepository;
import com.task.rewardpoints.dto.Reward;
import com.task.rewardpoints.dto.RewardResponse;
import com.task.rewardpoints.entity.Transaction;
import com.task.rewardpoints.exception.CustomerNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    private static final double THRESHOLD = 1e-6;

    private final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy/MM/dd");

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    private List<Transaction> transactions;

    @BeforeEach
    public void setUp() throws ParseException {
        transactions = Arrays.asList(
                new Transaction(1L, DATEFORMAT.parse("2022/07/08"), 1L, 49.99),
                new Transaction(2L, DATEFORMAT.parse("2022/07/18"), 1L, 50.00),
                new Transaction(3L, DATEFORMAT.parse("2022/07/25"), 1L, 99.99),
                new Transaction(4L, DATEFORMAT.parse("2022/07/28"), 1L, 100.01),
                new Transaction(5L, DATEFORMAT.parse("2022/08/18"), 1L, 49.99),
                new Transaction(6L, DATEFORMAT.parse("2022/08/28"), 1L, 50.00),
                new Transaction(7L, DATEFORMAT.parse("2022/08/29"), 1L, 99.99),
                new Transaction(8L, DATEFORMAT.parse("2022/08/30"), 1L, 100.01),
                new Transaction(9L, DATEFORMAT.parse("2022/09/08"), 1L, 49.99),
                new Transaction(10L, DATEFORMAT.parse("2022/09/18"), 1L, 50.00),
                new Transaction(11L, DATEFORMAT.parse("2022/09/25"), 1L, 99.99),
                new Transaction(12L, DATEFORMAT.parse("2022/09/28"), 1L, 100.01)
        );
    }

    @Test
    public void getRewards_withValidTransactionList_returnValidRewardResponseWithTotalAndRewardsList() {
        given(transactionRepository.findAllTransactionsByCustomerId(anyLong())).willReturn(transactions);
        RewardResponse rewardResponse = transactionService.getRewards(1L);
        //check customerId
        assertEquals(1L, rewardResponse.customerId);
        // Check total
        assertEquals(300.03, rewardResponse.total);

        // Check transaction list
        Assertions.assertEquals(3, rewardResponse.rewards.size());
        Map<Month, Reward> rewards = new HashMap<>();
        rewardResponse.rewards.forEach(reward -> rewards.put(reward.month, reward));
        Assertions.assertTrue(rewards.containsKey(Month.JULY));
        Assertions.assertTrue(rewards.containsKey(Month.AUGUST));
        Assertions.assertTrue(rewards.containsKey(Month.SEPTEMBER));
        assertEquals(100.01, rewards.get(Month.JULY).reward);
        assertEquals(100.01, rewards.get(Month.AUGUST).reward);
        assertEquals(100.01, rewards.get(Month.SEPTEMBER).reward);
    }

    @Test
    public void getRewards_withEmptyTransactions_throwsCustomerNotFoundException() {
        given(transactionRepository.findAllTransactionsByCustomerId(anyLong())).willReturn(new ArrayList<>());
        Assertions.assertThrows(CustomerNotFoundException.class, () -> transactionService.getRewards(1L));
    }

    private void assertEquals(double expect, double actual) {
        Assertions.assertTrue(Math.abs(expect - actual) < THRESHOLD, String.format("Expect around %.06f, but got %.06f", expect, actual));
    }
}
