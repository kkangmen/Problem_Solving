import java.util.*;

class Solution {
    
    List<int[]> answer = new ArrayList<>();
    
    public void move(int n, int start, int end){
        answer.add(new int[]{start, end});
    }
    
    public void hanoi(int n, int start, int end, int via){
        
        if (n == 1){
            move(n, start, end);
            return;
        }
        
        hanoi(n-1, start, via, end);
        move(n, start, end);
        hanoi(n-1, via, end, start);
    }
    
    public int[][] solution(int n) {
        
        hanoi(n, 1, 3, 2);
        return answer.toArray(new int[0][]);
    }
}