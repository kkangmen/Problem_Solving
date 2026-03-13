import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static boolean[] isUsed;
    static int[] answer;
    static int maxAnswer = Integer.MIN_VALUE;

    public static void calculate(){
        int sum = 0;
        for (int i = 0; i < N-1; i++){
            sum += Math.abs(answer[i] - answer[i+1]);
        }
        maxAnswer = Math.max(maxAnswer, sum);
    }

    public static void bruteForce(int count){
        if (count == N){
            calculate();
            return;
        }

        for (int i = 0; i < N; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                answer[count] = num[i];
                bruteForce(count+1);
                isUsed[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        isUsed = new boolean[N];
        answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        bruteForce(0);
        System.out.println(maxAnswer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}