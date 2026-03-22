import java.io.*;
import java.util.*;
    
public class Main {
    static int T, M, N, K;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> q = new LinkedList<>();

    public static class Point {
        int x;
        int y;
        Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y){
        q.offer(new Point(x, y));
        isVisited[x][y] = true;

        while (!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < M && 0 <= ny && ny < N){
                    if (map[nx][ny] == 1 && !isVisited[nx][ny]){
                        isVisited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            isVisited = new boolean[M][N];

            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int i = 0; i < M; i++){
                for (int j = 0; j < N; j++){
                    if (map[i][j] == 1 && !isVisited[i][j]){
                        answer++;
                        bfs(i, j);
                    }
                }
            }

            System.out.println(answer);
        }
        
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}