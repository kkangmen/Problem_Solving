import java.util.*;

class Solution {
    
    String[][] map;
    int[][] changed;
    
    public void changeLocate(){
        for (int j = 0; j < map[0].length; j++){
            for (int i = map.length-1; i >= 0; i--){
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
    
    public int countOne(){
        int count = 0;
        for (int i = 0; i < changed.length; i++){
            for (int j = 0; j < changed[0].length; j++){
                if (changed[i][j] == 1){
                    map[i][j] = "-";
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean hasToChange(){
        boolean flag = false;
        for (int i = 0; i < map.length-1; i++){
            for (int j = 0; j < map[0].length-1; j++){
                String s = map[i][j];
                if (s.equals("-")){
                    continue;
                }
                
                if (map[i][j+1].equals(s) &&
                   map[i+1][j].equals(s) &&
                   map[i+1][j+1].equals(s)){
                    flag = true;
                    changed[i][j] = 1;
                    changed[i][j+1] = 1;
                    changed[i+1][j] = 1;
                    changed[i+1][j+1] = 1;
                }
            }
        }
        return flag;
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        // 초기화
        map = new String[board.length][board[0].length()];    
        for (int i = 0; i < board.length; i++){
            String s = board[i];
            for (int j = 0; j < s.length(); j++){
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }
        
        while (true){
            
            changed = new int[board.length][board[0].length()];
            
            // 더 이상 없어지는 게 없다면
            if (!hasToChange()) break;
            
            // 1 개수 세기
            answer += countOne();
            
            // 자리 바꾸기
            changeLocate();
            
//             for (int i = 0; i < map.length; i++){
//                 for (int j = 0; j < map[0].length; j++){
//                     System.out.print(map[i][j]);
//                 }
//                 System.out.println();
//             }
        }
        return answer;
    }
}