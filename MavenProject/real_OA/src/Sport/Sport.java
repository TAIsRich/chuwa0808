package Sport;

public interface Sport {
    default void calculateAvgAge(int[] age) {
        int sum = 0;
        for(int i = 0; i < age.length; i++){
            sum += age[i];
        }
        sum = sum/age.length;
        System.out.println("The average age of the team is (" + sum  + ") ");
    }
     void retirePlayer(int id);
}
