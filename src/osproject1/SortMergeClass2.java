package osproject1;

import java.util.Arrays;

/**
 *
 * @author Mohamed
 */
public class SortMergeClass2 {
    private int[] globalInputArray;
    private int[] globalOutputArray;
    
    public SortMergeClass2(int[] arr) {
        globalInputArray = arr;
        globalOutputArray = new int[arr.length];
    }
    
    public final void sortArray() {
        SortingThread2 thrd1 = new SortingThread2(0, 
                (globalInputArray.length / 2) + 1,globalInputArray);
        SortingThread2 thrd2 = new SortingThread2((globalInputArray.length / 2) 
                + 1, globalInputArray.length,globalInputArray);
        
        MergingThread2 thrd3 = new MergingThread2(0, 
                (globalOutputArray.length / 2) + 1,globalInputArray,globalOutputArray);
        
        thrd1.run();
        thrd2.run();
        try {
            thrd3.run();
        } catch(Exception ex) {
            
        }
    }
    
    public int[] getOutput() {
        return globalOutputArray;
    }
}
    class SortingThread2 implements Runnable {
        private int start, end;
        private int[] arr;        
        public SortingThread2(int mStart, int mEnd,int[] array) {
            start = mStart;
            end = mEnd;
            arr = array;
        }
        
        @Override
        public void run() {
            Arrays.sort(arr, start, end);
        }
    }
    
    class MergingThread2 implements Runnable {
        private int start1, start2;
        private int[] arr1,arr2;
        public MergingThread2(int mStart1, int mStart2,int[] arrayIn,int[] arrayOut) {
            start1 = mStart1;
            start2 = mStart2;
            arr1 = arrayIn;
            arr2 = arrayOut;
        }
        
        @Override
        public void run() {
            int i = start1, j = start2, k = 0;
            
            while(i < start2 && j < arr2.length) {
                if(arr1[i] < arr1[j]) {
                    arr2[k++] = arr1[i++];
                } else if(arr1[j] < arr1[i]) {
                    arr2[k++] = arr1[j++];
                } else {
                    arr2[k++] = arr1[i++];
                    arr2[k++] = arr1[j++];
                }
            }
            
            while(i < start2) {
                arr2[k++] = arr1[i++];
            }
            
            while(j < arr2.length) {
                arr2[k++] = arr2[j++];
            }
        }
    }

