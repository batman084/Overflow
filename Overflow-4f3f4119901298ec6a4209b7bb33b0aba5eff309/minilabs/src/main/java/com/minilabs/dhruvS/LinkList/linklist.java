package com.minilabs.dhruvS.LinkList;

import java.util.*;


public class linklist extends a{
    private LinkedList<String> inputlist;
    public linklist(String[] arr) {
        inputlist = new LinkedList<String>();
        inputlist.addAll(Arrays.asList(arr));
    }
    public String[] sort() {
        inputlist.sort(Comparator.naturalOrder());
        return inputlist.toArray(new String[inputlist.size()]);
    }

}
