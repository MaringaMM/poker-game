package com.itq.sort;

import java.util.Arrays;

public class HandSorterRobo {

    private String[] playerHandToSort;

    //sort hand
    public HandSorterRobo(String[] PlayerHandToSort){
        Arrays.sort(PlayerHandToSort);
        this.playerHandToSort = PlayerHandToSort;
    }

    public String[] getPlayerHandToSort() {
        return playerHandToSort;
    }
}
