import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dayMap;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int answer = 0;
    static Queue<Point> q = new LinkedList<>();

    private static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y){
        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M){
                    if (map[nx][ny] == 0 && dayMap[nx][ny] == 0){
                        dayMap[nx][ny] = dayMap[p.x][p.y] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dayMap = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    dayMap[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 1){
                    q.offer(new Point(i, j));
                }
            }
        }

        if (!q.isEmpty()){
            Point peek = q.peek();
            bfs(peek.x, peek.y);
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0 && dayMap[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dayMap[i][j]);
            }
        }
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}