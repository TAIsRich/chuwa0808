package Sport;

import java.util.Arrays;

public class Cricket implements Sport{
    int[] playerIDs;
    public Cricket(){
        this.playerIDs = new int[11];
        Arrays.fill(playerIDs, 1);
        System.out.println("A new cricket team has been formed");
    }




    @Override
    public void retirePlayer(int id) {
        if(playerIDs[id] != -1){
            playerIDs[id] = -1;
            System.out.println("Player with id: (" + id + ") has retired");
        }else{
            System.out.println("Player with id: (" + id + ") has retired");
        }
    }


}
