import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dp = new int[100001];
    static Queue<Integer> q = new LinkedList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, -1);
        dp[N] = 0;
        q.offer(N);

        while (!q.isEmpty()){
            Integer loc = q.poll();
            if (loc-1 >= 0 && dp[loc-1] == -1){
                dp[loc-1] = dp[loc] + 1;
                q.offer(loc-1);
            }
            if (loc+1 <= 100000 && dp[loc+1] == -1){
                dp[loc+1] = dp[loc] + 1;
                q.offer(loc+1);
            }
            if (loc*2 <= 100000 && dp[loc*2] == -1){
                dp[loc*2] = dp[loc] + 1;
                q.offer(loc*2);
            }
        }

        System.out.println(dp[K]);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}