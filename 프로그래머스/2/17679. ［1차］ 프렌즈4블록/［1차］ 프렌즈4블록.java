import java.util.*;

class Solution {
    
    String[][] map;
    boolean[][] isChanged;
    int answer;
    
    public void changePosition(){
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
    
    public void countGone(){
        for (int i = 0; i < isChanged.length; i++){
            for (int j = 0; j < isChanged[i].length; j++){
                if (isChanged[i][j]){
                    map[i][j] = "-";
                    answer++;
                }
            }
        }
    }
    
    public boolean checkMap(){
        boolean flag = false;
        for (int i = 0; i < map.length-1; i++){
            for (int j = 0; j < map[i].length-1; j++){
                String s = map[i][j];
                if (s.equals("-")){
                    continue;
                }
                if (s.equals(map[i+1][j]) 
                   && s.equals(map[i][j+1])
                   && s.equals(map[i+1][j+1])){
                   flag = true;
                    isChanged[i][j] = true;
                    isChanged[i+1][j] = true;
                    isChanged[i][j+1] = true;
                    isChanged[i+1][j+1] = true;
                }
            }
        }
        return flag;
    }
    
    public int solution(int m, int n, String[] board) {
        answer = 0;
        
        map = new String[m][n];
        isChanged = new boolean[m][n];
        
        for (int i = 0; i < m; i++){
            String s = board[i];
            for (int j = 0; j < s.length(); j++){
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }
        
        while (true){
            // 없어지는 게 있나?
            if(!checkMap()){
                break;
            }
            
            // 없어진 개수 세기
            countGone();
            isChanged = new boolean[m][n];
            
            // System.out.println("없어지는 거는 -로 바꿈");
            // for (int i = 0; i < m; i++){
            //     for (int j = 0; j < n; j++){
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            
            // 위치 바꾸기
            changePosition();
            
            // System.out.println("위치 바꾸기");
            // for (int i = 0; i < m; i++){
            //     for (int j = 0; j < n; j++){
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
        return answer;
    }
}