import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int index = 0;
        for (int i = 0; i < A.length;){
            if (index == B.length){
                break;
            }
            
            if (A[i] < B[index]){
                answer++;
                i++;
                index++;
            } else {
                index++;
            }
        }
        return answer;
    }
}