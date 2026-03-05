import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int N;
    static int S;
    static int[] arr;
    static boolean[] isUsed;

    public static void dfs(int index, int sum){
        if (index == N){
            if (sum == S){
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N]; // [-7, -3, -2, 5, 8]
        isUsed = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        if (S == 0){
            answer--;
        }
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}