import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String color = board[h][w];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++){
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length){
                if (color.equals(board[nx][ny])){
                    answer++;
                }
            }
        }
        return answer;
    }
}