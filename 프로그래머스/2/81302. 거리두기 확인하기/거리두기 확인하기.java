import java.util.*;

class Solution {
    
    String[][] map;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public boolean isPossible2(int dir, int row, int col){
        boolean flag = true;
        int[] dx2;
        int[] dy2;
        
        // 오른쪽
        if (dir == 0){
            dx2 = new int[]{-1, 0, 1};
            dy2 = new int[]{0, 1, 0};
        } else if (dir == 1){ // 아래
            dx2 = new int[]{0, 1, 0};
            dy2 = new int[]{1, 0, -1};
        } else if (dir == 2){ // 왼쪽
            dx2 = new int[]{1, 0, -1};
            dy2 = new int[]{0, -1, 0};
        } else { // 위
            dx2 = new int[]{0, -1, 0};
            dy2 = new int[]{-1, 0, 1};
        }
        
        for (int i = 0; i < 3; i++){
            int nx = row + dx2[i];
            int ny = col + dy2[i];
            
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                if (map[nx][ny].equals("P")){
                    flag = false;
                }
            }
        }
        return flag;
    }
    
    public boolean isPossible(int row, int col){
        boolean flag = true;
        // 1단계 파티션일 경우, 
        for (int i = 0; i < 4; i++){
            int nx = row + dx[i];
            int ny = col + dy[i];
            
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                if (map[nx][ny].equals("X")){
                    continue;
                }
                if (map[nx][ny].equals("P")){
                    flag = false;
                    return flag;
                }
                // 2단계: 1단계가 'O'여서 다음 단계를 확인
                if(!isPossible2(i, nx, ny)){
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++){
            boolean flag = true;
            String[] place = places[i];
            map = new String[5][5];
            
            for (int j = 0; j < 5; j++){
                String s = place[j];
                for (int k = 0; k < 5; k++){
                    map[j][k] = String.valueOf(s.charAt(k));
                }
            }
            
            for (int row = 0; row < 5; row++){
                for (int col = 0; col < 5; col++){
                    if (map[row][col].equals("P")){
                        if (!isPossible(row, col)){
                            flag = false;
                        }
                    }
                }
            }
            if (flag){
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}