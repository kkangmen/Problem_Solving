import java.util.*;

class Solution {
    
    public int gcb(int a, int b){
        while (a != 0){
            int temp = b % a;
            b = a;
            a = temp;
        }    
        
        return b;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcbA = arrayA[0];
        if (arrayA.length > 1){
            gcbA = gcb(arrayA[0], arrayA[1]);
            for (int i = 2; i < arrayA.length; i++){
                gcbA = gcb(gcbA, arrayA[i]);
            }
        }

        int gcbB = arrayB[0];
        if (arrayB.length > 1){
            gcbB = gcb(arrayB[0], arrayB[1]);
            for (int i = 2; i < arrayB.length; i++){
                gcbB = gcb(gcbB, arrayB[i]);
            }
        }
        
        System.out.println(gcbA + " " + gcbB);
        
        boolean flagA = true;
        for (int i : arrayB){
            if (i % gcbA == 0){
                flagA = false;
            }
        }
        boolean flagB = true;
        for (int i : arrayA){
            if (i % gcbB == 0){
                flagB = false;
            }
        }
        
        if (!flagA && !flagB){
            return 0;
        } else {
            return Math.max(gcbA, gcbB);
        }
    }
}