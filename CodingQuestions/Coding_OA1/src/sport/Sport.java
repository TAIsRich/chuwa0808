package sport;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * @author: Flora Zhong
 * @date: 8/15/2022
 * @reference: https://java2blog.com/format-double-to-2-decimal-places-java/
 */

public interface Sport {
    default void calculateAvgAge(int[] ages) {
        OptionalDouble opt = Arrays.stream(ages).average();

        if (opt.isPresent()) {
          double ave = opt.getAsDouble();
          System.out.println("The average age of thr team is " + String.format("%.2f", ave));
        }
    }

    void retirePlayer(int id);
}
