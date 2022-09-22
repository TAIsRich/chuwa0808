package com.task.rewardpoints.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RewardResponse {
    public List<Reward> rewards = new ArrayList<>();
    public double total;
    public long customerId;
}
