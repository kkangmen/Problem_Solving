import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int h = citations.length; h >= 1; h--){
            int count = 0;
            for (int i = 0; i < citations.length; i++){
                if (citations[i] >= h){
                    count++;
                }
            }
            if (count >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}

// [0, 1, 3, 5, 6]