import java.util.*;

class Solution {
    
    int[][] map;
    static final int DEVIDE_NUM = 1000000007;
        
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        map = new int[n][m];
        
        // 초기화
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                map[i][j] = -1;
            }
        }
        
        // 물 웅덩이
        for (int[] puddle : puddles){
            map[puddle[1]-1][puddle[0]-1] = 0;
        }

        map[0][0] = 1;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == -1){
                    // 1행일 경우
                    if (i == 0){
                        map[i][j] = map[i][j-1];
                        continue;
                    } // 1열일 경우
                    if (j == 0){
                        map[i][j] = map[i-1][j];
                        continue;
                    }
                    map[i][j] = (map[i-1][j] + map[i][j-1] ) % DEVIDE_NUM;
                    
                }
            }
        }
        
//         for (int i = 0; i < n; i++){
//             for (int j = 0; j < m; j++){
//                 System.out.print(map[i][j] + " ");
//             }
//             System.out.println();
//         }
        return map[n-1][m-1];
    }
}