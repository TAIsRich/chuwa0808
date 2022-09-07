import java.util.Arrays;

public interface Sport {

    default void calculateAvgAge(int[] age) {
        double v = Arrays.stream(age).average().getAsDouble();
        System.out.println("The Average age of the team is" + String.format("%.2f", v));
    }

    void retirePlayer(int id);
}
