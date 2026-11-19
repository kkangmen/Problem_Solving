import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[][] map;
    static boolean[][] isVisited;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static boolean bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        isVisited[start[0]][start[1]] = true;

        while (!q.isEmpty()){
            int[] curNode = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                if (0 <= nx && nx < 16 && 0 <= ny && ny < 16
                && !isVisited[nx][ny]) {
                    if (map[nx][ny] == 0){
                        q.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                    }
                    else if (map[nx][ny] == 3){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            int t = Integer.parseInt(br.readLine());

            // 16*16 맵 생성 및 입력
            map = new int[16][16];
            for (int i = 0; i < 16; i++){
                String line = br.readLine();
                for (int j = 0; j < 16; j++){
                    map[i][j] = line.charAt(j) - '0';
                    if (map[i][j] == 2){
                        start = new int[]{i, j};
                    }
                    if (map[i][j] == 3){
                        end = new int[]{i, j};
                    }
                }
            }
            isVisited = new boolean[16][16];

            // bfs (1 = 벽, 0 = 길, 2 = 출발점, 3 = 도착점
            if (bfs(start)){
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }
        }
    }
}