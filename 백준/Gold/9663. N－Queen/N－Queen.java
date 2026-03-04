import java.io.*;
import java.util.*;

public class Main {
    static int[] row;
    static boolean[] isUsed;
    static int N;
    static int answer;
    public static boolean checkPossible(int count){
        // 두 점의 위치가 대각선인 경우 성립x
        for (int i = 0; i < count; i++){
            if (Math.abs(i - count) == Math.abs(row[i] - row[count])){
                return false;
            }
        }
        return true;
    }

    public static void dfs(int count){
        if (count == N){
            answer++;
            return;
        }

        for (int i = 0; i < N; i++){
            row[count] = i;
            if (!isUsed[i] && checkPossible(count)){
                isUsed[i] = true;
                dfs(count+1);
                isUsed[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        row = new int[N];
        isUsed = new boolean[N];

        dfs(0);
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}