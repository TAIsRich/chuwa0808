public enum accessType {entry,exit}

public class inAndOutRecord {
    private String recordId;
    private Timestamp time;
    private Vehicle v;
    private int number;
    private accessType accessType;


    public void inAndOutRecord(Timestamp time, Vehicle v, int num, accessType accessType){
        // ... 
    }
    
    // some getter and setter functions....
}
