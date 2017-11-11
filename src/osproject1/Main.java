/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osproject1;

/**
 *
 * @author mahmoud
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortMergeClass cc = new SortMergeClass(new int[]{-100, 5, -1, -10,
            -2, 10, 1000, 50, -10, -2, 0, -500});
        
        cc.sortArray();
        
        final int[] finalSortedArray = cc.getOutput();
        for(int i = 0; i < finalSortedArray.length; i++) {
            System.out.print(finalSortedArray[i] + " ");
        }
        
        System.out.println();
    }
    
}
