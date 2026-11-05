import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static StringBuilder sb;

    public static void dfs(int count, int N, int M, int[] answer) throws IOException {
        if (count == M){
            for (int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++){
            answer[count] = i;
            dfs(count+1, N, M, answer);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] answer = new int[M];

        dfs(0, N, M, answer);
        System.out.println(sb.toString());
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}