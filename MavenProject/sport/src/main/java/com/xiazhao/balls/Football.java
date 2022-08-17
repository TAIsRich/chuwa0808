package com.xiazhao.balls;

public class Football implements Sport {
    private int[] playerIDs;
    private final static int DEFAULT_SIZE = 12;

    public Football() {
        this(DEFAULT_SIZE);
    }

    public Football(int numbers) {
        this(null, numbers);
    }

    public Football(int[] playerIDs, int numbers) {
        this.playerIDs = new int[numbers];

        if (playerIDs != null) {
            int i = 0;
            for (int id : playerIDs) {
                this.playerIDs[i] = id;
                i++;
            }
        } else {
            for (int i = 0; i < numbers; i++) {
                this.playerIDs[i] = i + 1;
            }
        }

        System.out.println("A new football team has been formed");
    }

    @Override
    public void retirePlayer(int id) {
        this.playerIDs[id - 1] = -1;
        System.out.println("Player has already retired");
    }

    @Override
    public boolean isRetired(int id) {
        return this.playerIDs[id - 1] <= 0;
    }

    public void playerTransfer(int fee, int id) {
        if (isRetired(id)) {
            System.out.println("Player with id: {" + id + "} has been transferred with a fee of {" + fee + "}");
        } else {
            System.out.println("Player has already retired");
        }
    }
}
