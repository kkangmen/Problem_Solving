import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] number;
    static int[] answer;
    static Set<String> set = new LinkedHashSet<>();
    static StringBuilder sb;

    public static void bTracking(int count, int index){
        if (count == M){
            sb = new StringBuilder();
            for (int i : answer){
                sb.append(i).append(" ");
            }
            set.add(sb.toString().trim());
            return;
        }

        for (int i = index; i < N; i++){
            answer[count] = number[i];
            bTracking(count + 1, i);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        number = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);
        bTracking(0, 0);

        for (String s : set){
            System.out.println(s);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}