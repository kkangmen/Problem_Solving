import java.io.*;
import java.util.*;
    
public class Main {
    static int N;
    static int[] operator;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    static int[] num;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static int caculate(){
        int index = 1;
        int a = num[0];
        for (int i = 0; i < N-1; i++) {
            int b = num[index];
            switch (answer[i]) {
                case 0:
                    a = a + b;
                    break;
                case 1:
                    a = a - b;
                    break;
                case 2:
                    a = a * b;
                    break;
                case 3:
                    if (a < 0) {
                        a = -(Math.abs(a) / b);
                    } else {
                        a = a / b;
                    }
                    break;
            }
            index++;
        }
        return a;
    }

    public static void dfs(int count){
        if (count == N-1){
            int ans = caculate();
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }


        for (int i = 0; i < 4; i++){
            if (operator[i] > 0){
                operator[i]--;
                answer[count] = i;
                dfs(count+1);
                operator[i]++;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        answer = new int[N-1];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}