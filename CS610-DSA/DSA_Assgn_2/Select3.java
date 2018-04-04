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
public class Select3 {

    //static int arrLen = 0;

    public int SmartSelect(int[] arr, int left, int right, int kSmalElem) {
        CS610ProgAsgn2 objMain = new CS610ProgAsgn2();
        if (left > right) {
            return -3;
        }
        arr = findPivot(arr,0,5,arr.length);
        int v = arr[0];
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
            return SmartSelect(Sl, 0, Sl.length - 1, kSmalElem);
        } else if (kSmalElem <= n1 + n2) {
            return v;
        } else {
            return SmartSelect(Sg, 0, Sg.length - 1, kSmalElem - (n1+n2));     
        }

    }

    public int[] findPivot(int[] arr, int start, int end, int arrLen) {
        while (end != arrLen && !(end > arrLen)) {
            arr = InsertionSort(arr, start, end);
            arr = findMedian(arr, start, end);
            start = start + 5;
            end = end + 5;
        }
        if (end == arrLen) {
            arr = InsertionSort(arr, start, end);
            arr = findMedian(arr, start, end);
        }
        if (end > arrLen) {
            arr = InsertionSort(arr, start, arrLen);
            arr = findMedian(arr, start, arrLen);
        }
        
        while (arrLen > 2) {
            
            if (arrLen % 5 == 0) {
                end = arrLen / 5;
                rearrangeArr(arr, end);
                return findPivot(arr, 0, end, arrLen/5);
                
            } else {
                end = arrLen / 5 + 1;
                rearrangeArr(arr, end);
                return findPivot(arr, 0, end, end);
            }
        }
        return arr;
    }

    public void rearrangeArr(int[] arr, int end) {

        for (int i = 1; i < end; i++) {
            swap(arr, i, 5 * i);
        }
    }

    public int[] InsertionSort(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            int k = i;
            while (k > start && arr[k] < arr[k - 1]) {
                swap(arr, k, k - 1);
                k = k - 1;
            }
        }
        return arr;
    }

    public int[] findMedian(int[] arr, int start, int end) {
        int m = (start + end - 1) / 2;
        swap(arr, start, m);
        return arr;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
