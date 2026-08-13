import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int pointerA = 0; int pointerB = 0;
        while (pointerB < B.length){
            
            if (A[pointerA] < B[pointerB]){
                answer++;
                pointerA += 1;
                pointerB += 1;
            } else {
                pointerB += 1;
            }
        }
        return answer;
    }
}