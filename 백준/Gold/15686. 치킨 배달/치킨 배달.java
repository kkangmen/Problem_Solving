import java.io.*;
import java.util.*;
    
public class Main {
    public static int m = 0;
    public static boolean[] isUsed;
    public static List<Point> house;
    public static List<Point> chicken;
    public static int answer = Integer.MAX_VALUE;

    public static class Point{
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int calculate(){
        int sum = 0;
        for (int i = 0; i < house.size(); i++){
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++){
                if(isUsed[j]){
                    int distance = Math.abs(house.get(i).x - chicken.get(j).x) +
                            Math.abs(house.get(i).y - chicken.get(j).y);
                    temp = Math.min(distance, temp);
                }
            }
            sum += temp;
        }
        return sum;
    }

    public static void dfs(int count, int index){
        if (count == m){
            int distance = calculate();
            answer = Math.min(distance, answer);
            return;
        }

        for (int i = index+1; i < isUsed.length; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                dfs(count+1, i);
                isUsed[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
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

        dfs(0, -1);

        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}