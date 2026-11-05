import java.util.*;

class Solution {
    
    String[][] map;
    boolean[][] changed;
    
    public void moveToUp(int row, int col){
        for (int j = 0; j < col; j++){
            for (int i = row-1; i >= 0; i--){
                if (map[i][j].equals("-")){
                    for (int k = i-1; k >= 0; k--){
                        if (!map[k][j].equals("-")){
                            map[i][j] = map[k][j];
                            map[k][j] = "-";
                            break;
                        }   
                    }
                }
            }
        }    
    }
    
    public int countChanged(int row, int col){
        int num = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (changed[i][j]){
                    map[i][j] = "-";
                    num++;
                }
            }
        }
        return num;
    }
    
    public boolean searchAll(int row, int col){
        
        boolean flag = false;
        
        for (int i = 0; i < row-1; i++){
            for (int j = 0; j < col-1; j++){
                String s = map[i][j];
                if (!s.equals("-")){
                    if (map[i][j+1].equals(s) && map[i+1][j].equals(s)
                       && map[i+1][j+1].equals(s)){
                        changed[i][j] = true;
                        changed[i+1][j] = true;
                        changed[i][j+1] = true;
                        changed[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
        }    
        return flag;
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        map = new String[m][n];
        for (int i = 0; i < m; i++){
            String s = board[i];
            for (int j = 0; j < n; j++){
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }
        
        while (true){
            
            changed = new boolean[m][n];
            
            // 1. 전체 순회하면서 지워질 블록 1로 표시
            if (!searchAll(m, n)){
                break;
            }
            
            // 2. 1개수 세고 문자 -> "-"로 변경
            answer += countChanged(m, n);
            
            // 3. "-" 위로 올리기
            moveToUp(m, n);
        }
        return answer;
    }
}