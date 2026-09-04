import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];
        
        for (int i = 0; i < sequence.length; i++){
            if (i%2==0){
                arr2[i] = -sequence[i];
                arr1[i] = sequence[i];
            }
            if (i%2==1){
                arr1[i] = -sequence[i];
                arr2[i] = sequence[i];
            }
        }
        
        long cur = arr1[0];
        long max1 = arr1[0];
        for (int i = 1; i < arr1.length; i++){
            cur = Math.max(arr1[i], cur+arr1[i]);
            max1 = Math.max(max1, cur);
        }
        
        long cur2 = arr2[0];
        long max2 = arr2[0];
        for (int i = 1; i < arr2.length; i++){
            cur2 = Math.max(arr2[i], cur2+arr2[i]);
            max2 = Math.max(cur2, max2);
        }
        
        return Math.max(max1, max2);
    }
}