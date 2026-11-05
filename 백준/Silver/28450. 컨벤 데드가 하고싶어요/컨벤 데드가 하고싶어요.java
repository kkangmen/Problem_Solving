import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        dp = new long[N][M];

        for (int i = 0; i < N; i++){
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // dp
        dp[0][0] = graph[0][0];
        for (int i = 1; i < M; i++){
            dp[0][i] += dp[0][i-1] + graph[0][i];
        }
        for (int i = 1; i < N; i++){
            dp[i][0] += dp[i-1][0] + graph[i][0];
        }

        for (int i = 1; i < N; i++){
            for (int j = 1; j < M; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + graph[i][j];
            }
        }

        // check
        int H = Integer.parseInt(br.readLine());
        if (dp[N-1][M-1] > H){
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
            System.out.println(dp[N-1][M-1]);
        }

        // print
//        for (int i = 0; i < N; i++){
//            for (int j = 0; j < M; j++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
    }
}
