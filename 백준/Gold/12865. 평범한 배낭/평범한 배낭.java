import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[] value;
    static int[] weight;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];
        value = new int[N+1];
        weight = new int[N+1];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            value[i] = v;
            weight[i] = w;
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= K; j++){
                if (j-weight[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j-weight[i]] + value[i], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
//        //print
//        for (int i = 0; i <= N; i++){
//            for (int j = 0; j <= K; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}