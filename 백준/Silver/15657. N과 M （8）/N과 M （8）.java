import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void bTracking(int count, int index){
        if (count == M){
            for (int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < N; i++){
            answer[count] = num[i];
            bTracking(count + 1, i);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        bTracking(0, 0);
        System.out.println(sb.toString().trim());
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}