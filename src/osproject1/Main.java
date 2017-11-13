package osproject1;
import java.util.Random;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rn = new Random();
        int[] array = new int[100];
        int[] array2 = new int[100];
        for(int i=0;i<array.length;i++)
            array[i] = rn.nextInt(10000) - 5000;
        for(int i=0;i<array2.length;i++)
            array2[i] = rn.nextInt(10000) - 5000;
        SortMergeClass cc = new SortMergeClass(array);
        cc.sortArray();
        SortMergeClass2 cc2 = new SortMergeClass2(array2);
        cc2.sortArray();
        final int[] finalSortedArray = cc.getOutput();
        final int[] finalSortedArray2 = cc2.getOutput();
        for(int i = 0; i < finalSortedArray.length; i++) {
            System.out.print(finalSortedArray[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        for(int i = 0; i < finalSortedArray2.length; i++) {
            System.out.print(finalSortedArray2[i] + " ");
        }
        
        System.out.println();
    }
    
}
