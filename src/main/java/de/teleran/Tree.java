package de.teleran;

import static java.lang.Math.abs;

public class Tree {
    public int garlandLength(int[] arr){
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            length = length + abs((arr[i] - arr[i-1]));
        }
        return length;
    }
}
