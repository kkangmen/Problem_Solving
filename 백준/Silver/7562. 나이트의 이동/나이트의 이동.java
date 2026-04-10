import java.io.*;
import java.util.*;

public class Main {
    static int T, l;
    static int[][] map;
    static int[][] moveCount;
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
                    if (moveCount[nx][ny] == -1){
                        q.offer(new Point(nx, ny));
                        moveCount[nx][ny] = moveCount[p.x][p.y] + 1;

                        if (nx == end_x && ny == end_y){
                            System.out.println(moveCount[nx][ny]);
                            return;
                        }
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
            moveCount = new int[l][l];
            for (int i = 0; i < l; i++){
                Arrays.fill(moveCount[i], -1);
            }

            st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            q.offer(new Point(start_x, start_y));
            moveCount[start_x][start_y] = 0;

            st = new StringTokenizer(br.readLine());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            if (start_x == end_x && start_y == end_y){
                System.out.println(0);
            }
            else {bfs();};
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}