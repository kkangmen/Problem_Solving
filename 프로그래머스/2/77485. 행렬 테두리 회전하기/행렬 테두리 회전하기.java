import java.util.*;

class Solution {
    
    int[][] map;
    
    public int rotate(int[] query){
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        
        int temp = map[x1][y1];
        int min = temp;
        
        // 좌측
        for (int i = x1; i < x2; i++){
            map[i][y1] = map[i+1][y1];
            min = Math.min(min, map[i][y1]);
        }
        
        // 하단
        for (int i = y1; i < y2; i++){
            map[x2][i] = map[x2][i+1];
            min = Math.min(min, map[x2][i]);
        }
        
        // 우측
        for (int i = x2; i > x1; i--){
            map[i][y2] = map[i-1][y2];
            min = Math.min(min, map[i][y2]);
        }
        
        // 상단
        for (int i = y2; i > y1; i--){
            map[x1][i] = map[x1][i-1];
            min = Math.min(min, map[x1][i]);
        }
        
        map[x1][y1+1] = temp;
        return min;
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        
        // init
        map = new int[rows+1][columns+1];
        int num = 1;
        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= columns; j++){
                map[i][j] = num++;
            }
        }
        
        for (int[] query : queries){
            answer.add(rotate(query));
            
            // // 출력
            // for (int i = 1; i <= rows; i++){
            //     for (int j = 1; j <= columns; j++){
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}