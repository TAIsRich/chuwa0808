import java.util.Arrays;

public class client {
    public static void main(String[] args) {
        Cricket c = new Cricket();
        Football f = new Football();

        c.retirePlayer(1);
        f.retirePlayer(2);

        int[] age = new int[] {11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        c.calculateAvgAge(age);
        f.calculateAvgAge(age);

        f.playerTransfer(200,2);
        f.playerTransfer(100,2);

    }
}
