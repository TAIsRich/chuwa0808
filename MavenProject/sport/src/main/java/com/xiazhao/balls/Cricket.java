package com.xiazhao.balls;

public class Cricket implements Sport {
    private int[] playerIDs;
    private final static int DEFAULT_SIZE = 12;

    public Cricket(int[] playerIDs, int numbers) {
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
        System.out.println("A new cricket team has been formed");
    }

    public Cricket(int numbers) {
        this(null, numbers);
    }

    public Cricket() {
        this(DEFAULT_SIZE);
    }


    @Override
    public void retirePlayer(int id) {
        playerIDs[id - 1] = -1;
        System.out.println("Player has already retired");
    }

    @Override
    public boolean isRetired(int id) {
        boolean result = this.playerIDs[id - 1] <= 0;
        if (result) {
            System.out.println("This player" + 4 + "is retired");
        } else {
            System.out.println("This player" + 4 + "is NOT retired");
        }
        return result;
    }
}
