import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static boolean[] isUsed;
    static int[] answerList;
    static StringBuilder sb = new StringBuilder();

    public static void bruteForce(int count){
        if (count == N){
            for (int i : answerList){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                answerList[count] = num[i];
                bruteForce(count + 1);
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
        answerList = new int[N];
        
        for (int i = 1; i <= N; i++){
            num[i-1] = i;
        }

        bruteForce(0);
        System.out.println(sb.toString().trim());
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}