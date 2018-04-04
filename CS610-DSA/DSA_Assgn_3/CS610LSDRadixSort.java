import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayushiwadhwa
 */
public class CS610LSDRadixSort {
    
    public static void LSDRadixSort(String[] arr, int w) {
        int n = arr.length;
        int R = 256;
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++) {
                count[arr[i].charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < n; i++) {
                aux[count[arr[i].charAt(d)]++] = arr[i];
            }

            for (int i = 0; i < n; i++) {
                arr[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "";
        String outFile = "";
        FileWriter fw = null;
        if (args.length > 0) {
            filePath = args[0];
            outFile = args[1];
        }

        String str;
        List<String> list = new ArrayList<String>();
        try {
            //Users/ayushiwadhwa/Desktop/DSA/f.txt
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((str = br.readLine()) != null) {
                list.add(str);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Not found");
        } catch (IOException ex) {
            System.out.println();

        }
        String[] a = list.toArray(new String[0]);
        int n = a.length;

        
        int w = a[0].length();
        for (int i = 0; i < n; i++) {
            if (a[i].length() < w) {
                int diff = w - a[i].length();
                int j = 0;
                while (j < diff) {
                    a[i] = a[i] + " ";
                    j = j + 1;
                }
            }
            assert a[i].length() == w : "Strings must have fixed length";
        }

        LSDRadixSort(a, w);
        try {
            fw = new FileWriter(outFile);
            for (int i = 0; i < n; i++) {
                fw.write(a[i] + "\n");
                System.out.println(a[i]);
            }
            System.out.println("Document completed.");
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Not found");
        } catch (IOException ex) {
            System.out.println();

        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
    
}
