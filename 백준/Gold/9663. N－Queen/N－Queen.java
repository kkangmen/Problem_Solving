import java.io.*;
import java.util.*;
    
public class Main {
    static int N;
    static int[] row;
    static boolean[] isUsed;
    static int answer = 0;

    public static boolean isDiagnal(int count){
        for (int i = 0; i < count; i++){
            if (Math.abs(i - count) == Math.abs(row[i] - row[count])){
                return true;
            }
        }
        return false;
    }

    public static void backTracking(int count){
        if (count == N){
            answer++;
            return;
        }

        for (int i = 0; i < N; i++){
            row[count] = i;
            if(!isUsed[i] && !isDiagnal(count)){
                isUsed[i] = true;
                backTracking(count+1);
                isUsed[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        row = new int[N];
        isUsed = new boolean[N];

        backTracking(0);
        System.out.println(answer);
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}