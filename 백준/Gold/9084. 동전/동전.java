import java.io.*;
import java.util.*;

public class Main {
    static int[] coin;
    static int[] dp;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            int N = Integer.parseInt(br.readLine());

            coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            dp = new int[M+1];

            dp[0] = 1;
            for (int i = 0; i < N; i++){
                for (int j = 1; j <= M; j++){
                    if (j-coin[i] >= 0){
                        dp[j] += dp[j-coin[i]];
                    }
                }
            }

            System.out.println(dp[M]);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}