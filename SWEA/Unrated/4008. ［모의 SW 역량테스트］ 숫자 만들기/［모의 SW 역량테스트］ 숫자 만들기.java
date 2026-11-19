import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[] operator = new int[4]; // 연산자
    static int[] operand; // 피연산자
    static int[] result;
    static int max;
    static int min;
    static int answer;

    public static int calculate(){

        int front = operand[0];
        for (int i = 1; i < N; i++){
            int op = result[i-1];
            int back = operand[i];

            // 더하기
            if (op == 0){
                front += back;
            } else if (op == 1){
                front -= back;
            } else if (op == 2){
                front *= back;
            } else {
                front /= back;
            }
        }
        return front;
    }

    public static void bTracking(int cnt){
        // 만약 cnt가 n-1이 되면 종료
        if (cnt == N-1){
            int sum = calculate();
            if (max < sum){
                max = sum;
            }
            if (min > sum){
                min = sum;
            }
            answer = max-min;
            return;
        }
        //
        for (int i = 0; i < 4; i++){
            if (operator[i] > 0){
                operator[i]-=1;
                result[cnt] = i;
                bTracking(cnt+1);
                operator[i]+=1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
            // N 입력
            N = Integer.parseInt(br.readLine());
            // 각 연산자의 개수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }
            // N 배열 생성 및 숫자 입력
            operand = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                operand[i] = Integer.parseInt(st.nextToken());
            }
            // 백트래킹
            result = new int[N-1];
            bTracking(0);
            System.out.println("#" + test_case + " " + answer);
        }
    }
}