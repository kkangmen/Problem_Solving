import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static boolean[] isUsed;
    private static int[] arr = new int[10];

    public static void dfs(int count, int index){
        if (count == m){
            for (int i = 0; i < m; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = index+1; i <= n; i++){
            if (!isUsed[i]){
                arr[count] = i;
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

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isUsed = new boolean[n+1];
        dfs(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}