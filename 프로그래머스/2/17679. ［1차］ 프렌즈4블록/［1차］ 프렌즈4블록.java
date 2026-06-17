import java.util.*;

class Solution {
    
    String[][] boards;
    int[][] checked;
    
    public boolean checkChanged(){
        
        boolean flag = true;
        
        for (int i = 0; i < boards.length-1; i++){
            for (int j = 0; j < boards[0].length-1; j++){
                String s = boards[i][j];
                
                if (s.equals("-")){
                    continue;
                }
                
                if (boards[i][j+1].equals(s) && 
                   boards[i+1][j].equals(s) &&
                   boards[i+1][j+1].equals(s)){
                    checked[i][j] = 1;
                    checked[i][j+1] = 1;
                    checked[i+1][j] = 1;
                    checked[i+1][j+1] = 1;
                    
                    flag = false;
                }
            }   
        }
        
        return flag;
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        boards = new String[m][n];
        checked = new int[m][n];
        
        for (int i = 0; i < board.length; i++){
            String s = board[i];
            for (int j = 0; j < s.length(); j++){
                boards[i][j] = String.valueOf(s.charAt(j));
            }
        }
        
        while (true){
            checked = new int[m][n];
            
            boolean endFlag = checkChanged();
            
            if (endFlag){
                break;
            }
            
            // checked에 1이라면 문자 "-"로 바꾸기
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (checked[i][j] == 1){
                        boards[i][j] = "-";
                        answer += 1;
                    }
                }
            }
            
            // 위치 바꾸기
            for (int j = 0; j < n; j++){
                for (int i = m -1; i >= 0; i--){
                    if (boards[i][j].equals("-")){
                        for (int k = i-1; k >= 0; k--){
                            if (!boards[k][j].equals("-")){
                                boards[i][j] = boards[k][j];
                                boards[k][j] = "-";
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