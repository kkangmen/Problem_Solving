import java.io.*;
import java.util.*;
    
public class Main {
    static int N, S;
    static int[] arr;
    static int answer = 0;

    public static void pruning(int index, int sum){
        if (index == N){
            if (sum == S){
                answer++;
            }
            return;
        }

        pruning(index + 1, sum + arr[index]);
        pruning(index + 1, sum);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pruning(0, 0);

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