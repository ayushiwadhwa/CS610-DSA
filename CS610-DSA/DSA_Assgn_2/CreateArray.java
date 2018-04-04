/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs610progasgn2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ayushiwadhwa
 */
public class CreateArray {

    public int[] getArray(int j) {
        int[] intValues = {1, 2, 3, 4};
        try {
            if (j == 1) {
                BufferedReader br = new BufferedReader(new FileReader("//Users/ayushiwadhwa/Desktop/DSA/arrayOne.txt"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(", ");
                    intValues = new int[values.length];
                    for (int i = 0; i < values.length; i++) {
                        intValues[i] = Integer.parseInt(values[i]);
                    }
                }
            } else if (j == 2) {
                BufferedReader br = new BufferedReader(new FileReader("//Users/ayushiwadhwa/Desktop/DSA/arrayTwo.txt"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(", ");
                    intValues = new int[values.length];
                    for (int i = 0; i < values.length; i++) {
                        intValues[i] = Integer.parseInt(values[i]);
                    }
                }
            }
            else if (j == 3) {
                BufferedReader br = new BufferedReader(new FileReader("//Users/ayushiwadhwa/Desktop/DSA/arrayThree.txt"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(", ");
                    intValues = new int[values.length];
                    for (int i = 0; i < values.length; i++) {
                        intValues[i] = Integer.parseInt(values[i]);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Not found");
        } catch (IOException ex) {
            System.out.println();
            
        }
        return intValues;
    }
}
