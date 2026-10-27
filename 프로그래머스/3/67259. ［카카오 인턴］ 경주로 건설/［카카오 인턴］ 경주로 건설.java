import java.util.*;
class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][][] graph;
    Queue<int[]> q = new LinkedList<>();
    
    public void bfs(int x, int y, int row, int col, int[][] board){
        q.offer(new int[]{x, y, 0}); // 동쪽으로
        q.offer(new int[]{x, y, 1}); // 남쪽으로
        graph[0][0][0] = graph[0][0][1] = 0;
        
        while (!q.isEmpty()){
            int[] curNode = q.poll();
            int dir = curNode[2];
            // System.out.println("x: " + curNode[0] + " y: " + curNode[1]);
            for (int i = 0; i < 4; i++){
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                if (0 <= nx && nx < row && 0 <= ny && ny < col
                   && board[nx][ny] == 0){
                    // 추가 비용이 더 적고, 이동하는 방향이 같다면 100원 추가
                    if (dir == i && graph[nx][ny][i] > graph[curNode[0]][curNode[1]][dir] + 100){
                        graph[nx][ny][i] = graph[curNode[0]][curNode[1]][dir]+100;
                        // System.out.println("추가" + "x: " + nx + " y: " + ny + " cost:" + graph[nx][ny][i]);
                        q.offer(new int[]{nx, ny, i});
                    }
                    // 이동하는 방향이 수직이라면 600원추가
                    else if (graph[nx][ny][i] > graph[curNode[0]][curNode[1]][dir] + 600){
                        graph[nx][ny][i] = graph[curNode[0]][curNode[1]][dir]+600;
                        // System.out.println("추가" + "x: " + nx + " y: " + ny  + " cost:" + graph[nx][ny][i]);
                        q.offer(new int[]{nx, ny, i});
                    }
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        // bfs, 방향 정보가 필요함
        int row = board.length;
        int col = board[0].length;
        graph = new int[row][col][4];
        
        // graph 최대값으로 채우기
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                Arrays.fill(graph[i][j], Integer.MAX_VALUE);
            }
        }
        
        // (0,0,0), (0,0,1)를 넣고
        // (0,0) 부터 bfs 시작
        bfs(0, 0, row, col, board);
        
        for (int i = 0; i < 4; i++){
            answer = Math.min(answer, graph[row-1][col-1][i]);
        }
        return answer;
    }
}