/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsasorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;


/**
 *
 * @author ayushiwadhwa
 */
public class DSASorting {

    static int CompCount = 0;

    public void MergeSort(int[] mgrarr, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            int middle = (leftIndex + rightIndex) / 2;
            MergeSort(mgrarr, leftIndex, middle);
            MergeSort(mgrarr, middle + 1, rightIndex);
            Merge(mgrarr, leftIndex, middle, rightIndex);
        }

    }

    public void Merge(int[] newArr, int leftIndex, int middle, int rightIndex) {
        int sizeOfLeftArr = middle - leftIndex + 1;
        int sizeOfRightArr = rightIndex - middle;

        int LeftArr[] = new int[sizeOfLeftArr];
        int RightArr[] = new int[sizeOfRightArr];

        for (int i = 0; i < sizeOfLeftArr; ++i) {
            LeftArr[i] = newArr[leftIndex + i];
        }
        for (int j = 0; j < sizeOfRightArr; ++j) {
            RightArr[j] = newArr[middle + 1 + j];
        }
        int i = 0, j = 0;

        int k = leftIndex;
        while (i < sizeOfLeftArr && j < sizeOfRightArr) {
            int check = Compare(LeftArr[i], RightArr[j]);
            if (check == 0) {
                newArr[k] = LeftArr[i];
                i++;
            } else {
                newArr[k] = RightArr[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of LeftArr[] */
        while (i < sizeOfLeftArr) {
            newArr[k] = LeftArr[i];
            i++;
            k++;
        }

        /* Copy remaining elements of RightArr[] */
        while (j < sizeOfRightArr) {
            newArr[k] = RightArr[j];
            j++;
            k++;
        }

    }

    public void HeapSort(int[] heaparr) {
        int n = heaparr.length;

        // Build the max heap from array and call pushdown 
        //starting from one level above the leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            Pushdown(heaparr, i, n - 1);
        }

        // Simple Swap the largest element(root) 
        //with last leaf to sort it in ascending order.
        //Again call Pushdown
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = heaparr[0];
            heaparr[0] = heaparr[i];
            heaparr[i] = temp;

            Pushdown(heaparr, 0, i - 1);//
        }
    }

    void Pushdown(int arr[], int r, int n) {
        int s = -1;

        if ((2 * r + 1) > n) {
            return;
        }

        if ((2 * r + 1) == n || Compare(arr[(2 * r + 1)], arr[(2 * r + 2)]) == 1) {
            s = 2 * r + 1;
        } else {
            s = 2 * r + 2;
        }

        if (Compare(arr[r], arr[s]) == 0) {
            int swap = arr[r];
            arr[r] = arr[s];
            arr[s] = swap;

            // Recursively heapify the affected sub-tree
            Pushdown(arr, s, n);
        }

    }
    
    public void QuickSort(int[] arr, int left, int right)
    {
        if(left >= right)
            return;
        Random rand = new Random();
        int randomNum = rand.nextInt(right - left) + left;
        int k = randomNum;
        int temp = arr[k];
        arr[k] = arr[left];
        arr[left] = temp;
        int v = arr[left];
        int l = left + 1;
        int r = right;
        while(l<=r)
        {
            int x = arr[l];
            int y = arr[r];
            int z = v;
            int check1 = CompareQuick1(x,z);
            int check2 = CompareQuick2(y,z);
            while(l<=r && arr[l]<=v)
            { l = l + 1;}
            while(l<=r && arr[r] >= 1)
            { r = r - 1;}
            if(l<r)
            {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l=l+1;
                r=r-1;       
            }
        }
        int tmpr = arr[left];
        arr[left] = arr[r];
        arr[r] = tmpr;
        QuickSort(arr,left,r-1);
        QuickSort(arr,r+1,right);
        
    }
    

    public int Compare(int X, int Y) {
        if (X >= Y) {
            CompCount = CompCount + 1;
            return 1;
        } else {
            CompCount = CompCount + 1;
            return 0;
        }
    }
    
    public int CompareQuick1(int X, int Y) {
        int check = 0;
        if (X <= Y) {
            CompCount = CompCount + 1;
            check = 1;
            
        }
        return check;
    }
    public int CompareQuick2(int X, int Y) {
        int check = 0;
        if (X >= Y) {
            CompCount = CompCount + 1;
            check = 1;
            //return 2;
        }
        return check;
    }

    public int[] CreateArray(int size, String message) {
        if (message == "Sorted") {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
            }
            Arrays.sort(array);
            return array;
        } else if (message == "RevSorted") {
            int[] array = new int[size];
            int temp = -1;
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
            }
            Arrays.sort(array);

            for (int i = 0; i < array.length / 2; ++i) {
                temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }

            return array;
        } else if (message == "Random") {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100);
            }

            return array;
        }
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
        array[i] = (int)(Math.random() * 100);}
        return array;
    }

            
    public static void main(String[] args) {
        long startTime = 0;
        long stopTime = 0;
        DSASorting ds = new DSASorting();
        
        //int arr[] = {10, 7, 8, 9, 1, 5, 2};
	int n = 0;
        //ds.QuickSort(arr, 0, n-1);
        //ds.PrintArray(arr, "hurray");
        //System.out.println(CompCount);
        
        
        int sortedArrayOrig[] = ds.CreateArray(31, "Sorted");
        int[] sortedArray = sortedArrayOrig.clone();
        
        System.out.println("---------------------------APPLYING MERGE SORT ON SORTED ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(sortedArrayOrig, "1) Original array of 32 elements in sorted order");
        startTime = System.currentTimeMillis();
        ds.MergeSort(sortedArray, 0, sortedArray.length - 1);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(sortedArray, "1) Final array of 32 elements sorted using Merge Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();
        
        System.out.println("---------------------------APPLYING HEAP SORT ON SORTED ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(sortedArrayOrig, "1) Original array of 32 elements in sorted order");
        sortedArray = sortedArrayOrig;
        startTime = System.currentTimeMillis();
        ds.HeapSort(sortedArray);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(sortedArray, "1) Final array of 32 elements sorted using Heap Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();
        
        System.out.println("---------------------------APPLYING QUICK SORT ON SORTED ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(sortedArrayOrig, "1) Original array of 32 elements in sorted order");
        sortedArray = sortedArrayOrig;
        startTime = System.currentTimeMillis();
        n = sortedArray.length;
        ds.QuickSort(sortedArray,0,n-1);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(sortedArray, "1) Final array of 32 elements sorted using Quick Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();


        int revSortedArrayOrig[] = ds.CreateArray(31, "RevSorted");
        int[] revSortedArray = revSortedArrayOrig.clone();
        System.out.println("---------------------------APPLYING MERGE SORT ON REVERSE SORTED ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(revSortedArrayOrig, "1) Original array of 32 elements in reverse sorted order");
        startTime = System.currentTimeMillis();
        ds.MergeSort(revSortedArray, 0, revSortedArray.length - 1);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(revSortedArray, "1) Final array of 32 elements sorted using Merge Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();
        
        System.out.println("---------------------------APPLYING HEAP SORT ON SORTED ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(revSortedArrayOrig, "1) Original array of 32 elements in reverse sorted order");
        revSortedArray = revSortedArrayOrig;
        startTime = System.currentTimeMillis();
        ds.HeapSort(revSortedArray);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(revSortedArray, "1) Final array of 32 elements sorted using Heap Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();
        
        System.out.println("---------------------------APPLYING QUICK SORT ON REVERSE SORTED ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(revSortedArrayOrig, "1) Original array of 32 elements in reverse sorted order");
        revSortedArray = revSortedArrayOrig;  
        startTime = System.currentTimeMillis();
        ds.QuickSort(revSortedArray,0,n-1);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(revSortedArray, "1) Final array of 32 elements sorted using Quick Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();


        int randomArrayOrig[] = ds.CreateArray(31, "Random");
        int[] randomArray = sortedArrayOrig.clone();
        System.out.println("---------------------------APPLYING MERGE SORT ON RANDOM ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(randomArrayOrig, "1) Original array of 32 elements in random order");
        startTime = System.currentTimeMillis();
        ds.MergeSort(randomArray, 0, sortedArray.length - 1);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(randomArray, "1) Final array of 32 elements sorted using Merge Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();
        
        System.out.println("---------------------------APPLYING HEAP SORT ON RANDOM ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(randomArrayOrig, "1) Original array of 32 elements in random order");
        randomArray = randomArrayOrig;
        startTime = System.currentTimeMillis();
        ds.HeapSort(randomArray);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(randomArray, "1) Final array of 32 elements sorted using Heap Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();
        
        System.out.println("---------------------------APPLYING QUICK SORT ON RANDOM ARRAY OF SIZE 32---------------------------");
        ds.PrintArray(randomArrayOrig, "1) Original array of 32 elements in random order");
        randomArray = randomArrayOrig;
        startTime = System.currentTimeMillis();
        ds.QuickSort(randomArray,0,n-1);
        stopTime = System.currentTimeMillis();
        ds.PrintArray(randomArray, "1) Final array of 32 elements sorted using Quick Sort");
        ds.PrintDetails(stopTime, startTime);
        System.out.println();
        System.out.println("------------------------------------------------------END------------------------------------------------------");
        System.out.println();


//Part 2
        int randomArrayOrigS[] = ds.CreateArray(1023, "Random");
        int[] randomArrayS = randomArrayOrigS.clone();
//        System.out.println("---------------------------APPLYING MERGE SORT ON RANDOM ARRAY OF SIZE 1024---------------------------");
//        ds.PrintArray(randomArrayOrigS, "1) Original array of 1024 elements in random order");
        startTime = System.currentTimeMillis();
        ds.MergeSort(randomArrayS, 0, randomArrayS.length - 1);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayS, "1) Final array of 1024 elements sorted using Merge Sort");
        int arrMerS = CompCount;
        long arrMerStime = (stopTime - startTime);
//        ds.PrintDetails(stopTime, startTime);
//        System.out.println();
//        System.out.println("------------------------------------------------------END------------------------------------------------------");
//        System.out.println();
//        
//        
//        System.out.println("---------------------------APPLYING HEAP SORT ON RANDOM ARRAY OF SIZE 1024---------------------------");
//        ds.PrintArray(randomArrayOrigS, "1) Original array of 1024 elements in random order");
        randomArrayS = randomArrayOrigS;
        startTime = System.currentTimeMillis();
        ds.HeapSort(randomArrayS);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayS, "1) Final array of 1024 elements sorted using Heap Sort");
        int arrHeapS = CompCount;
        long arrHeapStime = (stopTime - startTime);
//        ds.PrintDetails(stopTime, startTime);
//        System.out.println();
//        System.out.println("------------------------------------------------------END------------------------------------------------------");
//        System.out.println();
//        
       randomArrayS = randomArrayOrigS;
        startTime = System.currentTimeMillis();
        n = randomArrayS.length;
        ds.QuickSort(randomArrayS,0,n-1);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayS, "1) Final array of 1024 elements sorted using Heap Sort");
        int arrQuickS = CompCount;
        long arrQuickStime = (stopTime - startTime); 
        
        
        int randomArrayOrigM[] = ds.CreateArray(32767, "Random");
        int[] randomArrayM = randomArrayOrigM.clone();
//        System.out.println("---------------------------APPLYING MERGE SORT ON RANDOM ARRAY OF SIZE 32767---------------------------");
//        ds.PrintArray(randomArrayOrigM, "1) Original array of 32767 elements in random order");
        startTime = System.currentTimeMillis();
        ds.MergeSort(randomArrayM, 0, randomArrayM.length - 1);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayM, "1) Final array of 32767 elements sorted using Merge Sort");
        int arrMerM = CompCount;
        long arrMerMtime = (stopTime - startTime);
//        ds.PrintDetails(stopTime, startTime);
//        System.out.println();
//        System.out.println("------------------------------------------------------END------------------------------------------------------");
//        System.out.println();
//        
//        
//        System.out.println("---------------------------APPLYING HEAP SORT ON RANDOM ARRAY OF SIZE 32767---------------------------");
//        ds.PrintArray(randomArrayOrigM, "1) Original array of 32767 elements in random order");
        randomArrayM = randomArrayOrigM;
        startTime = System.currentTimeMillis();
        ds.HeapSort(randomArrayM);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayM, "1) Final array of 32767 elements sorted using Heap Sort");
        int arrHeapM = CompCount;
        long arrHeapMtime = (stopTime - startTime);
//        ds.PrintDetails(stopTime, startTime);
//        System.out.println();
//        System.out.println("------------------------------------------------------END------------------------------------------------------");
//        System.out.println();
//
      randomArrayM = randomArrayOrigM;
        startTime = System.currentTimeMillis();
        n = randomArrayOrigM.length;
        ds.QuickSort(randomArrayM,0,n-1);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayM, "1) Final array of 32767 elements sorted using Heap Sort");
        int arrQuickM = CompCount;
        long arrQuickMtime = (stopTime - startTime);
        
        
        int randomArrayOrigL[] = ds.CreateArray(1048575, "Random");
        int[] randomArrayL = randomArrayOrigL.clone();
//        System.out.println("---------------------------APPLYING MERGE SORT ON RANDOM ARRAY OF SIZE 1048575---------------------------");
//        ds.PrintArray(randomArrayOrigL, "1) Original array of 1048575 elements in random order");
        startTime = System.currentTimeMillis();
        ds.MergeSort(randomArrayL, 0, randomArrayL.length - 1);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayL, "1) Final array of 1048575 elements sorted using Merge Sort");
        int arrMerL = CompCount;
        long arrMerLtime = (stopTime - startTime);
//        ds.PrintDetails(stopTime, startTime);
//        System.out.println();
//        System.out.println("------------------------------------------------------END------------------------------------------------------");
//        System.out.println();
//        
//        
//        System.out.println("---------------------------APPLYING HEAP SORT ON RANDOM ARRAY OF SIZE 1048575---------------------------");
//        ds.PrintArray(randomArrayOrigL, "1) Original array of 1048575 elements in random order");
        randomArrayL = randomArrayOrigL;
        startTime = System.currentTimeMillis();
        ds.HeapSort(randomArrayL);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayL, "1) Final array of 1048575 elements sorted using Heap Sort");
        int arrHeapL = CompCount;
        long arrHeapLtime = (stopTime - startTime);
//        ds.PrintDetails(stopTime, startTime);
//        System.out.println();
//        System.out.println("------------------------------------------------------END------------------------------------------------------");
//        System.out.println();
//        
        randomArrayL = randomArrayOrigL;
        startTime = System.currentTimeMillis();
        n = randomArrayOrigL.length;
        ds.QuickSort(randomArrayL,0,n-1);
        stopTime = System.currentTimeMillis();
//        ds.PrintArray(randomArrayL, "1) Final array of 1048575 elements sorted using Heap Sort");
        int arrQuickL = CompCount;
        long arrQuickLtime = (stopTime - startTime);
        
        System.out.println("Merge Sort(1024) - " + arrMerS + "(No. of comparisons)" + "|" + arrMerStime + " milliseconds(Time Consumed)");
        System.out.println("Heap Sort(1024) - " + arrHeapS + "(No. of comparisons)" + "|" + arrHeapStime + " milliseconds(Time Consumed)" );
        System.out.println("Quick Sort(1024) - " + arrQuickS + "(No. of comparisons)" + "|" + arrQuickStime + " milliseconds(Time Consumed)");
        System.out.println("Merge Sort(32767) - " + arrMerM + "(No. of comparisons)" + "|" + arrMerMtime + " milliseconds(Time Consumed)");
        System.out.println("Heap Sort(32767) - " + arrHeapM + "(No. of comparisons)" + "|" + arrHeapMtime + " milliseconds(Time Consumed)");
        System.out.println("Quick Sort(1024) - " + arrQuickM + "(No. of comparisons)" + "|" + arrQuickMtime + " milliseconds(Time Consumed)");
        System.out.println("Merge Sort(1048575) - " + arrMerL + "(No. of comparisons)" + "|" + arrMerLtime + " milliseconds(Time Consumed)");
        System.out.println("Heap Sort(1048575) - " + arrHeapL + "(No. of comparisons)" + "|" + arrHeapLtime + " milliseconds(Time Consumed)");
        System.out.println("Quick Sort(1024) - " + arrQuickL + "(No. of comparisons)" + "|" + arrQuickLtime + " milliseconds(Time Consumed)");

        try {

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("INDEX " + ex.getLocalizedMessage() + " is out of bounds");
        } catch (Exception ex) {
            System.out.println("INVALID INPUT");
        }
    }

    public void PrintArray(int[] array, String msg) {
        System.out.println(msg);
        for (int i = 0; i < array.length; i++) {
            System.out.print("a[" + i + "] = " + array[i] + " ");
        }
        System.out.println();
    }

    public void PrintDetails(long stopTime, long startTime) {
        System.out.println("Details - ");
        System.out.println("Elapsed time was " + (stopTime - startTime) + " miliseconds.");
        System.out.println("No. of key comparisons = " + CompCount);
        CompCount = 0;
    }

}
