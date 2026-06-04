import java.util.*;

class Solution {
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 초기화
        String[][] map = new String[m][n];
        for (int i = 0; i < board.length; i++){
            String s = board[i];
            for (int j = 0; j < s.length(); j++){
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }
        
        
        while (true){
            boolean flag = true;
            boolean[][] check = new boolean[m][n];
            
            for (int i = 0; i < m-1; i++){
                for (int j = 0; j < n-1; j++){
                    String s = map[i][j];
                    if (s.equals("-")){
                        continue;
                    }
                    if (map[i][j+1].equals(s) && map[i+1][j+1].equals(s) && map[i+1][j].equals(s)){
                        check[i][j] = true;
                        check[i][j+1] = true;
                        check[i+1][j+1] = true;
                        check[i+1][j] = true;
                        flag = false;
                    }
                }
            }
            
            if (flag){
                break;
            }
            
            // 지운 것 표시
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (check[i][j]){
                        answer += 1;
                        map[i][j] = "-";
                    }
                }
            }
            // 스왑
            for (int j = 0; j < n; j++){
                for (int i = m-1; i >= 0; i--){
                    if (map[i][j].equals("-")){
                        for (int k = i-1; k >= 0; k--){
                            if (!map[k][j].equals("-")){
                                String temp = map[k][j];
                                map[k][j] = map[i][j];
                                map[i][j] = temp;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}