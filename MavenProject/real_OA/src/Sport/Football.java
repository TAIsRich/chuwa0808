package Sport;

import java.util.Arrays;

public class Football implements Sport{
    int[] playerIDs;
    public Football(){
        this.playerIDs = new int[11];
        Arrays.fill(playerIDs, 1);
        System.out.println("A new football team has been formed");

    }




    @Override
    public void retirePlayer(int id) {
        if(playerIDs[id-1] != -1){
            playerIDs[id-1] = -1;
            System.out.println("Player with id: (" + id + ") has retired");
        }else{
            System.out.println("Player with id: (" + id + ") has retired");
        }
    }

    protected void playerTransfer(int fee, int id){
        if(playerIDs[id - 1] == 1){
            System.out.println("Player with id: (" + id + ") has been transferred with a fee of (" + fee + ")");
        }else{
            System.out.println("Player has already retired");
        }
    }
}
