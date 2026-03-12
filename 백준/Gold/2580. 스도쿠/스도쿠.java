
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static List<Point> blankList = new ArrayList<>();

    public static class Point {
        private int x;
        private int y;

        public Point (int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isPossible(int x, int y, int number){
        // 가로
        for (int i = 0; i < 9; i++){
            if (i == y) continue;;
            if (map[x][i] == number){
                return false;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++){
            if (i == x) continue;;
            if (map[i][y] == number){
                return false;
            }
        }
        // 정사각형
        for (int i = x/3*3; i < x/3*3+3; i++){
            for (int j = y/3*3; j < y/3*3+3; j++){
                if (i == x && j == y) continue;
                if (map[i][j] == number){
                    return false;
                }
            }
        }
        return true;
    }

    public static void bTracking(int count){
        if (count == blankList.size()){
            // 정답 map 출력
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        Point point = blankList.get(count);
        for (int i = 1; i < 10; i++){
            if (isPossible(point.x, point.y, i)){
                map[point.x][point.y] = i;
                bTracking(count + 1);
                map[point.x][point.y] = 0;
            }
        }
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0){
                    blankList.add(new Point(i, j));
                }
            }
        }

        bTracking(0);


        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}