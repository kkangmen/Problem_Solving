import java.io.*;
import java.util.*;

public class Main {
    static int T, l;
    static int[][] map;
    static int[] dx = {1, 2, 2, 1, -1, -2,-2,-1};
    static int[] dy = {2, 1,-1,-2, -2, -1, 1, 2};
    static Queue<Point> q;
    static int end_x;
    static int end_y;
    public static class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < l && 0 <= ny && ny < l){
                    if (map[nx][ny] == -1){
                        q.offer(new Point(nx, ny));
                        map[nx][ny] = map[p.x][p.y] + 1;
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
            l = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            map = new int[l][l];
            for (int i = 0; i < l; i++){
                Arrays.fill(map[i], -1);
            }

            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            q.offer(new Point(start_x, start_y));
            map[start_x][start_y] = 0;

            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(map[end_x][end_y]);
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}