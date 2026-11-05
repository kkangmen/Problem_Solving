import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] row;
    static boolean[] isUsed;
    static int answer = 0;

    public static boolean isPossible(int index){
        for (int i = 0; i < index; i++){
            if (Math.abs(i - index) == Math.abs(row[i] - row[index])){
                return false;
            }
        }
        return true;
    }

    public static void permutation(int count){
        if (count == N){
            answer++;
            return;
        }

        for (int i = 0; i < N; i++){
            row[count] = i;
            if (!isUsed[i] && isPossible(count)){
                isUsed[i] = true;
                permutation(count + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        row = new int[N];
        isUsed = new boolean[N];

        permutation(0);
        System.out.println(answer);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}