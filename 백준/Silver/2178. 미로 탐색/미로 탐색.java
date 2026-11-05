import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, distance;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> q = new LinkedList<>();

    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y){
        q.offer(new Point(x, y));
        distance[x][y] = 1;

        while (!q.isEmpty()){
            Point p = q.poll();
            int px = p.x;
            int py = p.y;
            for (int i = 0; i < 4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M){
                    if (map[nx][ny] == 1 && distance[nx][ny] == 0){
                        q.offer(new Point(nx, ny));
                        distance[nx][ny] = distance[px][py] + 1;
                    }
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
        distance = new int[N][M];

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        bfs(0, 0);
        System.out.println(distance[N-1][M-1]);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}