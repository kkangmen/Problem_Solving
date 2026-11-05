import java.io.*;
import java.util.*;

public class p1280 {

    static int N;
    static boolean[] isUsed;
    static int[] row;
    static int answer;

    public static boolean isPossible(int x, int y){
        // 만약 현재 좌표 중에 하나라도 대각선이 있다면 false 반환
        // 대각선 = 각 좌표의 뺸 절댓값이 같다면 대각선
        for (int i = 0; i < x; i++){
            if (Math.abs(i - x) == Math.abs(row[i]-y)){
                return false;
            }
        }
        return true;
    }

    public static void dfs(int count){
        // 만약 count가 N이 되면 리턴
        // 갯수 증가
        if (count == N){
            answer++;
            return;
        }

        // row 순서대로 각자 가능한 위치 선점
        for (int i = 0; i < N; i++){
            if (!isUsed[i] && isPossible(count, i)){
                row[count] = i;
                isUsed[i] = true;
                dfs(count+1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            // 백트래킹
            // N, isUsed, row 입력 받기
            N = sc.nextInt();
            row = new int[N];
            isUsed = new boolean[N];

            // 백트래킹 시작
            answer = 0;
            dfs(0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}