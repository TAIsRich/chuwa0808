package exercise.OA;

import java.util.Arrays;

public class Cricket implements Sport{
    int[] playerIDs;

    public Cricket(){
        this.playerIDs = new int[11];
        Arrays.fill(playerIDs, 1);
        System.out.println("A new cricket team has been formed");
    }

    public void calculateAvgAge(int[] age){
        int result = 0;
        for(int num : age){
            result += num;
        }
        double avgAge = (double)(result / age.length);
        System.out.println("The average age of the team is" + avgAge);
    }

    public void retirePlayer(int id){
        playerIDs[id-1] = -1;
        System.out.println("Player has already retired");
    }
}
