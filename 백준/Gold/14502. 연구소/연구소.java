import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> q = new LinkedList<>();
    static int answer = 0;

    private static class Point {
        int x;
        int y;
        Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int countNonVirus(){
        int count = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (copyMap[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 2){
                    q.offer(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < N; i++){
            copyMap[i] = Arrays.copyOf(map[i], map[i].length);
        }

        while (!q.isEmpty()){
            Point curPoint = q.poll();

            for (int i = 0; i < 4; i++){
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M){
                    if (copyMap[nx][ny] == 0){
                        copyMap[nx][ny] = 2;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    private static void buildWall(int count){
        if (count == 3){
            bfs();
            answer = Math.max(answer, countNonVirus());
            return;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    buildWall(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}