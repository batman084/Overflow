package com.minilabs.gautam.SortsPOJO;

public class NameG implements Comparable<NameG>{
    private int nameLen;
    private String name;
    public NameG(String name){
        this.name = name;
        this.nameLen = name.length();
    }

    public int getNameLen() {
        return nameLen;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name{" +
                "nameLength=" + nameLen +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(NameG otherNameG) {
        int compVal = Integer.compare(getNameLen(), otherNameG.getNameLen());
        if (compVal == 0) {
            compVal = getName().compareTo(otherNameG.getName());
        }
        return compVal;
    }
}
