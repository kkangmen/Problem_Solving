import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[][] count;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Queue<Point> q = new LinkedList<>();
    static int groupNumber = 0;
    static List<Integer> houseNumber = new ArrayList<>();

    private static class Point{
        int x;
        int y;
        Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y){
        int houseTotal = 1;
        count[x][y] = groupNumber;
        q.offer(new Point(x, y));

        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N){
                    if (count[nx][ny] == 0 && map[nx][ny] == 1){
                        count[nx][ny] = groupNumber;
                        q.offer(new Point(nx, ny));
                        houseTotal++;
                    }
                }
            }
        }
        houseNumber.add(houseTotal);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        count = new int[N][N];

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (count[i][j] == 0 && map[i][j] == 1){
                    groupNumber += 1;
                    bfs(i, j);
                }
            }
        }

        System.out.println(groupNumber);
        Collections.sort(houseNumber);
        for (int i : houseNumber){
            System.out.println(i);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}