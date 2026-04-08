import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int maxHeight = 0;
    static int[] safePlaceList;
    static Queue<Point> q = new LinkedList<>();
    static int answer = 0;

    public static class Point {
        int x;
        int y;
        Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int x, int y, int height){
        q.offer(new Point(x, y));
        isVisited[x][y] = true;

        while (!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N){
                    if (map[nx][ny] > height && !isVisited[nx][ny]){
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

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < map[i][j]){
                    maxHeight = map[i][j];
                }
            }
        }

        safePlaceList = new int[maxHeight+1];

        for (int height = 0; height <= maxHeight; height++){
            int countSafePlace = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (map[i][j] > height && !isVisited[i][j]){
                        countSafePlace++;
                        bfs(i, j, height);
                    }
                }
            }

            safePlaceList[height] = countSafePlace;
            // isVisited 초기화
            for (int i = 0; i < N; i++){
                Arrays.fill(isVisited[i], false);
            }
        }

//        for (int i = 1; i <= maxHeight; i++){
//            System.out.println(safePlaceList[i]);
//        }
        for (int i = 0; i <= maxHeight; i++){
            answer = Math.max(answer, safePlaceList[i]);
        }

        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}