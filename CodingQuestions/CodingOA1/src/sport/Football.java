package sport;

import java.util.Arrays;

public class Football implements Sport{
  private final int count;
  private int[] playerIDs;

  public Football() {
    count = 11;
    playerIDs = new int[count];
    Arrays.fill(playerIDs, 1);
    System.out.println("A new football team has been formed.");
  }

  @Override
  public void retirePlayer(int id) {
    if (id < 1 || id > 11) {
      System.out.println("Please input a valid player ID.");
    }

    playerIDs[id - 1] = -1;
    System.out.println("Player " + id + " has already retired.");
  }

  public void playerTransfer(int fee, int id) {
    if (id < 1 || id > 11) {
      System.out.println("Please input a valid player ID.");
    }

    if (playerIDs[id - 1] == 1) {
      System.out.println("Player with id: "  + id + " has been transferred with a fee of " + fee + ".");
    }
    else {
      System.out.println("Player " + id + " has already retired.");
    }
  }
}
