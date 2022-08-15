package sport;

import java.util.Arrays;

public class Cricket implements Sport {
  private int count;
  private int[] playerIDs;

  public Cricket() {
    count = 11;
    playerIDs = new int[count];
    Arrays.fill(playerIDs, 1);
    System.out.println("A new cricket team has been formed.");
  }

  @Override
  public void retirePlayer(int id) {
    if (id < 1 || id > 11) {
      System.out.println("Please input a valid player ID.");
    }

    playerIDs[id - 1] = -1;
    System.out.println("Player " + id + " has already retired");
  }
}
