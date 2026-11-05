import java.io.*;
import java.util.*;
    
public class Main {
    static int N, M;
    static int[][] map;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static boolean[] isUsed;
    static int answer = Integer.MAX_VALUE;

    public static class Point {
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y =y;
        }
    }

    public static int caculate(){
        int totalDistance = 0;
        for (int i = 0; i < house.size(); i++){
            int distance = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++){
                if (isUsed[j]){
                    int gap = Math.abs(house.get(i).x - chicken.get(j).x) +
                            Math.abs(house.get(i).y - chicken.get(j).y);
                    distance = Math.min(distance, gap);
                }
            }
            totalDistance += distance;
        }
        return totalDistance;
    }

    public static void bTracking(int count, int index){
        if (count == M){
            int totalDistance = caculate();
            answer = Math.min(answer, totalDistance);
            return;
        }

        for (int i = index; i < chicken.size(); i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                bTracking(count + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1){
                    house.add(new Point(i, j));
                }
                else if (map[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }
        isUsed = new boolean[chicken.size()];

        bTracking(0, 0);
        System.out.println(answer);
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}