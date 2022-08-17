package com.xiazhao.client;

import com.xiazhao.balls.Cricket;
import com.xiazhao.balls.Football;

public class Client {
    public static void main(String[] args) {
        Cricket cricket = new Cricket();
        Football football = new Football();

        cricket.retirePlayer(3);
        football.retirePlayer(2);

        int[] age = new int[]{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        cricket.calculateAvgAge(age);
        football.calculateAvgAge(age);

        football.playerTransfer(200, 2);
        football.playerTransfer(200, 9);

        cricket.isRetired(4);
    }
}
