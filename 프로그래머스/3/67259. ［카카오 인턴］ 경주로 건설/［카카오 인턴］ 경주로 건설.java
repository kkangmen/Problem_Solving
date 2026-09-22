import java.util.*;

class Solution {
    
    int[][][] info;
    int[][][] cost;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Queue<int[]> q = new LinkedList<>();
    
    public void bfs(int row, int col, int[][] board){
        q.offer(new int[]{0, 0, 0});
        q.offer(new int[]{0, 0, 1});
        cost[0][0][0] = 0;
        cost[0][0][1] = 0;
        
        while (!q.isEmpty()){
            int[] curNode = q.poll();
            // System.out.println(curNode[0] + " " + curNode[1]);
            
            int direct = curNode[2];
            for (int i = 0; i < 4; i++){
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                
                if (0 <= nx && nx < row && 0 <= ny && ny < col
                   && board[nx][ny] == 0){
                    // 방향이 같다면
                    int charge = 0;
                    if (direct == i){
                        charge += 100;
                    } else {
                        charge += 600;
                    }
                    
                    // 새로운 금액이 더 작다면
                    if (cost[nx][ny][i] > cost[curNode[0]][curNode[1]][curNode[2]] + charge){
                        cost[nx][ny][i] = cost[curNode[0]][curNode[1]][curNode[2]] + charge;
                        // System.out.println(cost[nx][ny][i]);
                        q.offer(new int[]{nx, ny, i});
                    }
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        
        int row = board.length;
        int col = board[0].length;
        info = new int[row][col][4];
        cost = new int[row][col][4];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs(row, col, board);
        
        // print
        // for (int i = 0; i < row; i++){
        //     for (int j = 0; j < col; j++){
        //         int min = cost[i][j][0];
        //         for (int k = 0; k < 4; k++){
        //             min = Math.min(min, cost[i][j][k]);
        //         }
        //         System.out.print(min + " ");
        //     }
        //     System.out.println();
        // }
        
        int answer = cost[row-1][col-1][0];
        for (int i = 1; i < 4; i++){
            answer = Math.min(answer, cost[row-1][col-1][i]);
        }
        return answer;
    }
}