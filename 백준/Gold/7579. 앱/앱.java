import java.io.*;
import java.util.*;

public class Main {
    static int[] value;
    static int[] weight;
    static int[][] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dp = new int[N+1][10001];
        value = new int[N+1];
        weight = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++){
            for (int j = 0; j <= 10000; j++){
                if (j - weight[i] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j - weight[i]] + value[i], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for (int i = 0; i <= 10000; i++){
            if (dp[N][i] >= M){
                System.out.println(i);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}