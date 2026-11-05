import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] num;
    static int[] answer;
    static Set<String> set = new LinkedHashSet<>();
    static StringBuilder sb;

    public static void bTracking(int count){
        if (count == M){
            sb = new StringBuilder();
            for (int i : answer){
                sb.append(i).append(" ");
            }
            set.add(sb.toString().trim());
            return;
        }

        for (int i = 0; i < N; i++){
            answer[count] = num[i];
            bTracking(count+1);
        }
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        bTracking(0);

        sb = new StringBuilder();
        for (String s : set){
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}