/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osproject1;

import java.util.Arrays;

/**
 *
 * @author mahmoud
 */
public class SortMergeClass {
    private int[] globalInputArray;
    private int[] globalOutputArray;
    
    public SortMergeClass(int[] arr) {
        globalInputArray = arr;
        globalOutputArray = new int[arr.length];
    }
    
    public final void sortArray() {
        SortingThread thrd1 = new SortingThread(0, 
                (globalInputArray.length / 2) + 1);
        SortingThread thrd2 = new SortingThread((globalInputArray.length / 2) 
                + 1, globalInputArray.length);
        
        MergingThread thrd3 = new MergingThread(0, 
                (globalInputArray.length / 2) + 1);
        
        thrd1.start();
        thrd2.start();
        try {
            thrd1.join();
            thrd2.join();
            thrd3.start();
            thrd3.join();
        } catch(Exception ex) {
            
        }
    }
    
    public int[] getOutput() {
        return globalOutputArray;
    }
    
    public class SortingThread extends Thread {
        private int start, end;
        
        public SortingThread(int mStart, int mEnd) {
            start = mStart;
            end = mEnd;
        }
        
        @Override
        public void run() {
            Arrays.sort(globalInputArray, start, end);
        }
    }
    
    public class MergingThread extends Thread {
        private int start1, start2;
        
        public MergingThread(int mStart1, int mStart2) {
            start1 = mStart1;
            start2 = mStart2;
        }
        
        @Override
        public void run() {
            int i = start1, j = start2, k = 0;
            
            while(i < start2 && j < globalOutputArray.length) {
                if(globalInputArray[i] < globalInputArray[j]) {
                    globalOutputArray[k++] = globalInputArray[i++];
                } else if(globalInputArray[j] < globalInputArray[i]) {
                    globalOutputArray[k++] = globalInputArray[j++];
                } else {
                    globalOutputArray[k++] = globalInputArray[i++];
                    globalOutputArray[k++] = globalInputArray[j++];
                }
            }
            
            while(i < start2) {
                globalOutputArray[k++] = globalInputArray[i++];
            }
            
            while(j < globalOutputArray.length) {
                globalOutputArray[k++] = globalInputArray[j++];
            }
        }
    }
}
