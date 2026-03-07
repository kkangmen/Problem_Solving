import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static boolean[] isUsed;
    static int[][] graph;
    static int answer = Integer.MAX_VALUE;

    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int caculate(){
        int sum = 0;
        for (int i = 0; i < house.size(); i++){
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++){
                if (isUsed[j]){
                    temp = Math.min(Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y), temp);
                }
            }
            sum += temp;
        }
        return sum;
    }

    public static void btracking(int index, int count){
        if (count == M){
            answer = Math.min(answer, caculate());
            return;
        }

        if (index == chicken.size()){
            return;
        }

        isUsed[index] = true;
        btracking(index + 1, count+1);
        isUsed[index] = false;
        btracking(index + 1, count);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1){
                    house.add(new Point(i, j));
                }
                else if (graph[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        isUsed = new boolean[chicken.size()];
        btracking(0, 0);

        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}