import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] answer;

    public static int bfs(int x, int y){
        // cnt, 큐 선언
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        isVisited[x][y] = true;
        // 큐가 빌 때까지
        while (!q.isEmpty()) {
            // 상하좌우로 이동해서
            int[] curNode = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N
                        && !isVisited[nx][ny]) {
                    // 방문하지 않았고, 이동하려는 방에 적힌 숫자가 현재보다 +1이라면 큐에 삽입
                    if (map[curNode[0]][curNode[1]] + 1 == map[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        isVisited[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // tc 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = new int[2];

            // N 입력 및 N*N 배열 생성, 값 입력
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // N*N 만큼 이중 for문으로 bfs 시작
            // 현재 방보다 이동할 수 있는 방이 더 많다면 최신화 (방의 번호화 갯수)
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    isVisited = new boolean[N][N];
                    int total = bfs(i, j);
                    if (answer[1] < total){
                        answer[0] = map[i][j];
                        answer[1] = total;
                    } else if (answer[1] == total){
                        if (answer[0] > map[i][j]){
                            answer[0] = map[i][j];
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer[0] + " " + answer[1]);
        }
    }
}