import java.io.*;
import java.util.*;

public class p1244{

    static char[] num;
    static int N;
    static Set<String> set ;
    static int answer;

    public static void change(int i, int j){
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void bTracking(int cnt){
        // Set에 담을 현재 num + cnt 키를 만들고, 만약 set에 이미 존재하면 return
        String key = new String(num) + cnt;
        if (!set.add(key)){
            return;
        }

        // 만약 cnt가 교환 횟수라면 중단
        if (cnt == N) {
            // answer 최신화
            answer = Math.max(answer, Integer.parseInt(String.valueOf(num)));
            return;
        }

        //
        for (int i = 0; i < num.length-1; i++){
            for (int j = i+1; j < num.length; j++){
                change(i, j);
                bTracking(cnt+1);
                change(i, j);
            }
        }
    }
    public static void main(String[] args) throws Exception {

        // tc 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){

            set = new HashSet<>();
            answer = 0;
            // 숫자(num)과 교환 횟수(N) 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = st.nextToken().toCharArray();
            N = Integer.parseInt(st.nextToken());

            // 백트래킹
            bTracking(0);

            // 출력
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
// 1 2 3 4 -> 2 1 3 4