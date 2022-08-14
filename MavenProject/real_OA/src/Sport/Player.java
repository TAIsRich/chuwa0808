package Sport;

public class Player {
    public static void main(String[] args){
        Cricket cricket = new Cricket();


        int[] age = new int[]{18, 14,15,33,45,65,77,55,60,11,17};

        cricket.calculateAvgAge(age);
        cricket.retirePlayer(2);
        System.out.println("------------------------------------\nFootball: " );
        Football football = new Football();
        football.retirePlayer(4);
        football.calculateAvgAge(age);
        football.playerTransfer(500, 4);
        football.playerTransfer(700, 3);
    }
}
