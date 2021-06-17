package com.minilabs.gautam.LinkedLists;

import java.util.*;

public class GArrayList extends Base {
    private ArrayList<String> csList;
    private ArrayList<String> addList;
    private ArrayList<String> removeList;
    public GArrayList(String[] arr) {
        csList = new ArrayList<String>();
        csList.addAll(Arrays.asList(arr));
    }

    public String[] sort() {
        csList.sort(Comparator.naturalOrder());
        return csList.toArray(new String[csList.size()]);
    }
    public void add() {
        addList = csList;
        addList.add("111"); //add string "111" to linked list
        addList.sort(Comparator.naturalOrder());
    }

    public void remove() {
        removeList = csList;
        removeList.remove("111"); //remove string "111" from linked list
        removeList.sort(Comparator.naturalOrder());
    }
}
