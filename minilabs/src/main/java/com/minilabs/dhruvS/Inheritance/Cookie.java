package com.minilabs.dhruvS.Inheritance;

public class Cookie {
    public int chocChipNum;
    public int cookieDiameter;

    public Cookie(int chocChipNum, int cookieDiameter) {
        this.chocChipNum = chocChipNum;
        this.cookieDiameter = cookieDiameter;
    }

    public String toString() {
        return ("Used " + chocChipNum + " chocolate chips to make a cookie with a diameter of " + cookieDiameter);
    }

    public static class mnmCookie extends Cookie {
        public int mnmCount;

        public mnmCookie(int chocChipNum, int cookieDiameter, int StartmnmCount) {
            super(chocChipNum, cookieDiameter);
            mnmCount = StartmnmCount;
        }

        public void addMnm(int addNum) {
            mnmCount = mnmCount + addNum;
        }

        @java.lang.Override
        public String toString() {
            return (super.toString() + " number of MnM's used was " + mnmCount);
        }
    }
}

