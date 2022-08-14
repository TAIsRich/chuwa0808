package org.example;

public class Parking_Slot {

    private boolean[][] slots; // true has car, fals



    Parking_Slot(int floor, int max_capacity){
        slots = new boolean[floor][max_capacity];
    }

    // return true when there is car in slot, false otherwise
    private boolean check_Slot(int floor, int number){
        return slots[floor][number];
    }

    //return true when car is added into slot
    //return false when car is not added into slot
    public boolean addCar(int floor, int number){
        //if no car in slot
        if(!check_Slot( floor, number)){
            slots[floor][number] = true;
            return true;
        }else{
            //if there is car in slot
            return false;
        }
    }

    // true -> car move out of slot
    // false -> no car to move
    public boolean delCar(int floor, int number){
        //if car inside slot
        if(check_Slot(floor, number)){
            slots[floor][number] = false;
            return true;
        }else{
            //if there is no car in slot
            return false;
        }
    }
}