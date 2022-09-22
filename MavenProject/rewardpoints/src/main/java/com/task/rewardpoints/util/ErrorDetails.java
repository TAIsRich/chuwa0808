package com.task.rewardpoints.util;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorDetails {
    private Date date;
    private String message;
    private String details;
}
