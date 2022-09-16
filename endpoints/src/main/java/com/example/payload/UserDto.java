package com.example.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;

    private Integer totleReward;

    private Integer MonthReward;

}
