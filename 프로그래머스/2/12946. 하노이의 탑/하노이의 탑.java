import java.util.*;

class Solution {
    
    List<int[]> answer;
    
    public void hanoi(int n, int from, int to, int temp){
        
        if (n == 1){
            answer.add(new int[]{from, to});
            // System.out.println(n + "을 " + from + "에서 " + to + "로 이동.");
            return;
        }
        
        hanoi(n-1, from, temp, to);
        answer.add(new int[]{from, to});
        // System.out.println("move()함수: " + n + "을 " + from + "에서 " + to + "로 이동.");
        hanoi(n-1, temp, to, from);
    }
    
    public List<int[]> solution(int n) {
        answer = new ArrayList<>();
        
        hanoi(n, 1, 3, 2);
        return answer;
    }
}