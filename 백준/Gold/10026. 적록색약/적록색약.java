
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Character[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> q = new LinkedList<>();

    private static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y, char c){
        q.offer(new Point(x, y));
        isVisited[x][y] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N){
                    if (!isVisited[nx][ny] && map[nx][ny] == c){
                        isVisited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new Character[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < N; j++){
                map[i][j] = s.charAt(j);
            }
        }

        // 적록색약이 아닌 사람
        int noCount = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if(!isVisited[i][j]){
                    noCount++;
                    bfs(i, j, map[i][j]);
                }
            }
        }

        // 방문 초기화
        for (int i = 0; i < N; i++){
            Arrays.fill(isVisited[i], false);
        }

        // 적록색약인 사람 (R == G)
        int count = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!isVisited[i][j]){
                    count++;
                    bfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(noCount + " " + count);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}