import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static boolean[] isUsed;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void btracking(int count){
        if (count == M){
            for (int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                answer[count] = num[i];
                btracking(count + 1);
                isUsed[i]= false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        isUsed = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        btracking(0);
        System.out.println(sb.toString());
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}