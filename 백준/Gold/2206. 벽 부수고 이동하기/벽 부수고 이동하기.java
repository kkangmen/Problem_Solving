import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> q = new LinkedList<>();

    public static class Point {
        int x;
        int y;
        int cnt;
        boolean broken;
        Point (int x, int y, int cnt, boolean broken){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.broken = broken;
        }
    }

    public static void bfs(){
        q.offer(new Point(0, 0, 1, false));
        isVisited[0][0][0] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if (p.x == N - 1 && p.y == M - 1){
                System.out.println(p.cnt);
                return;
            }

            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M){
                    // 벽이 아닐 때
                    if (map[p.x][p.y] == 0){
                        // 여태까지 부신 벽이 없고, 벽을 부시지 않고 처음 방문한 경우
                        if (!p.broken && !isVisited[nx][ny][0]){
                            q.add(new Point(nx, ny, p.cnt+1, false));
                            isVisited[nx][ny][0] = true;
                        }
                        // 이전에 벽을 부셨고, 아직 벽을 부신 이후 아직 방문하지 않은 경우
                        if (p.broken && !isVisited[nx][ny][1]){
                            q.add(new Point(nx, ny, p.cnt+1, true));
                            isVisited[nx][ny][1] = true;
                        }
                    }
                    // 벽일 경우
                    else {
                        // 벽을 부신 적이 없는 경우
                        if (!p.broken){
                            q.add(new Point(nx, ny, p.cnt+1, true));
                            isVisited[nx][ny][1]= true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M][2];

        for (int i = 0; i < N; i++){
            String row = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = row.charAt(j) - '0';
            }
        }

        bfs();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}