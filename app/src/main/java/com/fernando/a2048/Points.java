package com.fernando.a2048;

/**
 * Created by ferna on 10/11/2017.
 */

public class Points {

    private static Points uniqueInstance;
    private long totalPoints = 0;

    private Points(){

    }

    public static synchronized Points getInstance(){
        if( uniqueInstance == null){
            uniqueInstance = new Points();
        }
        return uniqueInstance;
    }

    public long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
