package sport;

import java.util.Arrays;

/**
 * @author Flora Zhong
 * @date 8/15/22
 * @reference https://java2blog.com/format-double-to-2-decimal-places-java/
 */

public interface Sport {
  default void calculateAvgAge(int[] ages) {
    double ave = Arrays.stream(ages).average().getAsDouble();
    System.out.println("The average age of thr team is " + String.format("%.2f", ave));
  }

  void retirePlayer(int id);
}
