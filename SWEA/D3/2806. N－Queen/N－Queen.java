import java.io.*;

public class Solution {

    static int N;
    static int[] arr;
    static boolean[] isUsed;
    static int answer = 0;

    public static boolean isDiagonal(int idx, int x){
        // (3,5) (1,7)
        for (int i = 0; i < idx; i++){
            if (Math.abs(idx-i) == Math.abs(x -arr[i])){
                return true;
            }
        }
        return false;
    }

    public static void bTracking(int idx){

        // 만약 idx가 n이 되면 중단
        if (idx == N){
            answer++;
            return;
        }

        // isUsed가 false이면 true로 만든다.
        // 이때 대각선이어도 안된다.
        for (int i = 0; i < N; i++){
            if (!isUsed[i] && !isDiagonal(idx, i)){
                isUsed[i] = true;
                arr[idx] = i;
                bTracking(idx+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            answer = 0;
            // 백트래킹
            // n 입력, 크키 n 배열 생성
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            isUsed = new boolean[N];

            bTracking(0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}