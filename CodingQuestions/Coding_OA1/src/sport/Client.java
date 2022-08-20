package sport;

/**
 * @author: Flora Zhong
 * @date: 8/15/22
 * @reference: https://java2blog.com/format-double-to-2-decimal-places-java/
 */

public class Client {
    public static void main(String[] args) {
        Cricket cricket = new Cricket();
        Football football = new Football();

        cricket.retirePlayer(7);
        football.retirePlayer(8);

        int[] ages = new int[] {11, 12, 7, 9, 10, 6, 7, 8, 9, 10, 11};
        cricket.calculateAvgAge(ages);
        football.calculateAvgAge(ages);

        football.playerTransfer(650000, 8);
        football.playerTransfer(650000, 7);
    }
}
