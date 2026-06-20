import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        int[][] triangle = new int[n][n];
        
        int num = 1;
        int x = -1;
        int y = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (i % 3 == 0){
                    x++;
                } else if (i % 3 == 1){
                    y++;
                } else {
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (triangle[i][j] == 0){
                    continue;
                }
                answer.add(triangle[i][j]);
            }
        }
        return answer;
    }
}