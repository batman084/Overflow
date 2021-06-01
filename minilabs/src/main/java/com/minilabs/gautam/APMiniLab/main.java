package com.minilabs.gautam.APMiniLab;

public class main {
    
    private int minSteps;
    private int totalSteps;
    private int numDays;
    private int numActiveDays;

    public main(int a) {
        minSteps = a;
        totalSteps = 0;
        numDays = 0;
        numActiveDays = 0;
    }
   
    public void addDailySteps(int steps) {
        totalSteps += steps;
        numDays++;
        
        if (steps >= minSteps) {
            numActiveDays++;
        }
    }

    public int activeDays() {
        return numActiveDays;
    }
    
    public double averageSteps() {
        if (numDays == 0) {
            return 0.0;
        }
        else {
            return (double) totalSteps / numDays;
        }
    }

    public int getTotalSteps() {
        return totalSteps;
    }

}