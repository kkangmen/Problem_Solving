import java.util.*;

class Solution {
    
    int[][] triangle;
    int num = 1;
    int row = -1;
    int col = 0;
    int number = 1;
    
    public void goDown(int count){
        for (int i = 0; i < count; i++){
            row += 1;
            triangle[row][col] = number;
            number++;
        }
    }
    
    public void goRight(int count){
        for (int i = 0; i < count; i++){
            col += 1;
            triangle[row][col] = number;
            number++;
        }
    }
        
    public void goDiag(int count){
        for (int i = 0; i < count; i++){
            row -= 1;
            col -= 1;
            triangle[row][col] = number;
            number++;
        }
    }
    
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        triangle = new int[n][n];
        
        for (int i = 0; i < n; i++){
            switch (i%3) {
                case 0: goDown(n-i);
                    break;
                case 1: goRight(n-i);
                    break;
                case 2: goDiag(n-i);
                    break;
            }
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (triangle[i][j] != 0){
                    answer.add(triangle[i][j]);                    
                }
            }
        }
        return answer;
    }
}