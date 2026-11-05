import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] map;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] days;
    static Queue<Point> q = new LinkedList<>();
    static int answer = Integer.MIN_VALUE;
    public static class Point {
        int x;
        int y;
        int z;
        Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void bfs(Point start){
        days[start.x][start.y][start.z] = 1;

        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 6; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && 0 <= nz && nz < H){
                    if (map[nx][ny][nz] == 0 && days[nx][ny][nz] == 0){
                        q.offer(new Point(nx, ny, nz));
                        days[nx][ny][nz] = days[p.x][p.y][p.z] + 1;
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
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];
        days = new int[N][M][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    days[i][j][k] = map[i][j][k];
                    if (map[i][j][k] == 1) {
                        q.offer(new Point(i, j, k));
                    }
                }
            }
        }

        if (!q.isEmpty()) {
            Point p = q.peek();
            bfs(p);
        }

//        for (int k = 0; k < H; k++) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(days[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (answer < days[i][j][k]){
                        answer = days[i][j][k];
                    }
                    if (days[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer-1);
        br.close();
    }

    public static void main (String[]args) throws IOException {
        solution();
    }
}