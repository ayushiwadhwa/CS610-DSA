/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs610progasgn2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 *
 * @author ayushiwadhwa
 */
public class CS610ProgAsgn2 {

    /**
     * @param args the command line arguments
     */
    static int CompCount = 0;
    public static void main(String[] args) {
            int kthSmallElem = 5;
        
            CreateArray objArr = new CreateArray();
            
            int origArr[] = objArr.getArray(1);
            int select1arr[] = Arrays.copyOfRange(origArr, 0, origArr.length);
            int select2arr[] = Arrays.copyOfRange(origArr, 0, origArr.length);
            int select3arr[] = Arrays.copyOfRange(origArr, 0, origArr.length);
            
            Select1 obj1 = new Select1();
            int kSmalElem1 = obj1.SelectUsingQuickSort(select1arr, 0, select1arr.length-1,kthSmallElem - 1);
            System.out.println("Algorithm QuickSort: "+origArr.length+"(n), "+kthSmallElem +"(k), "+kSmalElem1+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            CS610ProgAsgn2.CompCount = 0;
////-------------------------------------------------------------------------------------------------------------------------------------------            
            Select2 obj2 = new Select2();
            int a = obj2.QuickSelect(select2arr, 0, select2arr.length-1, kthSmallElem);
            System.out.println("Algorithm QuickSelect: "+origArr.length+"(n), "+(kthSmallElem) +"(k), "+a+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            CS610ProgAsgn2.CompCount = 0;
//-------------------------------------------------------------------------------------------------------------------------------------------            
            Select3 obj3 = new Select3();
            int b = obj3.SmartSelect(select3arr, 0, select2arr.length-1 ,kthSmallElem);
            System.out.println("Algorithm SmartSelect: "+origArr.length+"(n), "+(kthSmallElem) +"(k), "+b+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            System.out.println();
//            
            int origArr2[] = objArr.getArray(2);
            int select1arr1[] = Arrays.copyOfRange(origArr2, 0, origArr2.length);
            int select2arr1[] = Arrays.copyOfRange(origArr2, 0, origArr2.length);
            int select3arr1[] = Arrays.copyOfRange(origArr2, 0, origArr2.length);
            
            Select1 obj12 = new Select1();
            int kSmalElem2 = obj12.SelectUsingQuickSort(select1arr1, 0, select1arr1.length-1,kthSmallElem - 1);
            System.out.println("Algorithm QuickSort: "+origArr2.length+"(n), "+kthSmallElem +"(k), "+kSmalElem2+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            CS610ProgAsgn2.CompCount = 0;
////-------------------------------------------------------------------------------------------------------------------------------------------            
            Select2 obj22 = new Select2();
            int a2 = obj22.QuickSelect(select2arr1, 0, select2arr1.length-1, kthSmallElem);
            System.out.println("Algorithm QuickSelect: "+origArr2.length+"(n), "+(kthSmallElem) +"(k), "+a2+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            CS610ProgAsgn2.CompCount = 0;
////-------------------------------------------------------------------------------------------------------------------------------------------            
            Select3 obj32 = new Select3();
            int b2 = obj32.SmartSelect(select3arr1, 0, select3arr1.length-1 ,kthSmallElem);
            System.out.println("Algorithm SmartSelect: "+origArr2.length+"(n), "+(kthSmallElem) +"(k), "+b2+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            System.out.println();
//            
//            
            int origArr3[] = objArr.getArray(3);
            int select1arr3[] = Arrays.copyOfRange(origArr3, 0, origArr3.length);
            int select2arr3[] = Arrays.copyOfRange(origArr3, 0, origArr3.length);
            int select3arr3[] = Arrays.copyOfRange(origArr3, 0, origArr3.length);
            
            Select1 obj13 = new Select1();
            int kSmalElem13 = obj13.SelectUsingQuickSort(select1arr3, 0, select1arr3.length-1,kthSmallElem - 1);
            System.out.println("Algorithm QuickSort: "+origArr3.length+"(n), "+kthSmallElem +"(k), "+kSmalElem13+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            CS610ProgAsgn2.CompCount = 0;
////-------------------------------------------------------------------------------------------------------------------------------------------            
            Select2 obj23 = new Select2();
            int a3 = obj23.QuickSelect(select2arr3, 0, select2arr3.length-1, kthSmallElem);
            System.out.println("Algorithm QuickSelect: "+origArr3.length+"(n), "+(kthSmallElem) +"(k), "+a3+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            CS610ProgAsgn2.CompCount = 0;
////-------------------------------------------------------------------------------------------------------------------------------------------            
            Select3 obj33 = new Select3();
            int b3 = obj33.SmartSelect(select3arr3, 0, select2arr3.length-1 ,kthSmallElem);
            System.out.println("Algorithm SmartSelect: "+origArr3.length+"(n), "+(kthSmallElem) +"(k), "+b3+"(A[k]), "+"Num of key comparisons: "+CS610ProgAsgn2.CompCount);
            System.out.println();
    }
    public int Compare(int X, int Y, String Algo) {
        String parts[] = Algo.split(",");
        String part1 = parts[0]; 
        String part2 = parts[1];
        if(part1.equals("Select1") && part2.equals("l"))
        {
            if(X<=Y)
            {
                CompCount = CompCount + 1;
                return 1;
            }
            else return 0;
        }
        if(part1.equals("Select1") && part2.equals("r"))
        {
            if(X>=Y)
            {
                CompCount = CompCount + 1;
                return 1;
            }
            else return 0;
        }
        if(part1.equals("Select3") && part2.equals("l"))
        {
            if(X<Y)
            {
                CompCount = CompCount + 1;
                return 1;
            }
            else return 0;
        }
        if(part1.equals("Select3") && part2.equals("r"))
        {
            if(X>Y)
            {
                CompCount = CompCount + 1;
                return 1;
            }
            else return 0;
        }
        return -1;
    }
    
    
}
    

