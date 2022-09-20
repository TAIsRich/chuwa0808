package com.example.rewardpoints.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;

    @NotEmpty
    private Double money;

    private Double reward;

    private LocalDate createDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionDto)) return false;
        TransactionDto that = (TransactionDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getMoney(), that.getMoney()) && Objects.equals(getReward(), that.getReward()) && Objects.equals(getCreateDateTime(), that.getCreateDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMoney(), getReward(), getCreateDateTime());
    }
}
