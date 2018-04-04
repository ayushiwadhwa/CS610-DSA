/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs610progasgn2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author ayushiwadhwa
 */
public class Select2 {
    
    
    public int QuickSelect(int[] arr, int left, int right, int kSmalElem) {
        
        CS610ProgAsgn2 objMain = new CS610ProgAsgn2();
        if (left > right) {
            return -3;
        }
        int randomNum = ThreadLocalRandom.current().nextInt(left, right + 1);
        int k = randomNum;
        int temp = arr[k];
        arr[k] = arr[left];
        arr[left] = temp;
        int v = arr[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            while (l <= r && objMain.Compare(arr[l], v, "Select1,l") == 1) {
                l = l + 1;
            }
            while (l <= r && objMain.Compare(arr[r], v, "Select1,r") == 1) {
                r = r - 1;
            }
            if (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l = l + 1;
                r = r - 1;
            }
        }
        int tmpr = arr[left];
        arr[left] = arr[r];
        arr[r] = tmpr;
        //int postn = v;
        int n1 = l - 1;
        int n2 = 1;
        int n3 = arr.length - l;
        int[] Sl = Arrays.copyOfRange(arr, 0, n1);
        int[] Se = Arrays.copyOfRange(arr, r, r + 1);
        int[] Sg = Arrays.copyOfRange(arr, l, arr.length);
        //Sl,Sg,Se
        if (kSmalElem <= n1) {
            return QuickSelect(Sl, 0, Sl.length - 1, kSmalElem);
        } else if (kSmalElem <= n1 + n2) {
            return v;
        } else {
            return QuickSelect(Sg, 0, Sg.length - 1, kSmalElem - (n1+n2));     
        }
        //return v;
    }

}
