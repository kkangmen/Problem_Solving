import java.io.*;
import java.util.*;

public class p1244{

    static char[] arr;
    static int N;
    static String answer;
    static Set<String> memo;

    public static void change(int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void dfs(int count){

        String key = new String(arr) + "," + count;
        if (!memo.add(key)) return;

        // 만약 count가 N이 되면 현재 값 비교 및 종료
        if (count == N){
            String cur = new String(arr);
            if (cur.compareTo(answer) > 0){
                answer = cur;
            }
            return;
        }
        //
        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                change(i, j);
                dfs(count+1);
                change(i, j);
            }
        }
    }

    public static void main(String args[]) throws Exception {

        // tc 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){

            // 숫자와 반복 횟수 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            arr = num.toCharArray();

            N = Integer.parseInt(st.nextToken());

            // 완전탐색 시작
            answer = "";
            memo = new HashSet<>();
            dfs(0);

            // 출력
            System.out.println("#" + test_case + " " + answer);
        }
    }
}