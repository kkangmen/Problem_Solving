import java.util.*;
import java.io.*;

public class Main {
    static final int mod = 1000000007;
    static long[][] dp = new long[2001][2001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        // dp
        for (int i = 0; i <= 2000; i++){
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%mod;
            }
        }

        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            if (S.charAt(i) == '>' && S.charAt(i + 1) == '<') {
                for (int k = 0; i - k >= 0 && i + 1 + k < N; k++) {
                    if (S.charAt(i - k) == '>' && S.charAt(i + 1 + k) == '<') {
                        int front = i - k;
                        int rear = N - 1 - (i + 1 + k);
                        answer = (answer + dp[front + rear][front]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
        // print
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i).i + " " + (N-1-list.get(i).j));
//        }

    }
}
