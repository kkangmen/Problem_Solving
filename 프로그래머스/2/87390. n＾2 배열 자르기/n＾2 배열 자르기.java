import java.util.*;

class Solution {
    public List<Long> solution(int n, long left, long right) {
        List<Long> answer = new ArrayList<>();
        
        for (long l = left; l <= right; l++){
            long row = l/n;  // 1
            long col = l%n;  // 3
            
            if (row >= col){
                answer.add(row+1);
            }
            else {
                answer.add(col+1);
            }
        }
        return answer;
    }
}

// 1 2 3 4
// 2 2 3 4
// 3 3 3 4
// 4 4 4 4
