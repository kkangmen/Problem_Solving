import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] num;
    static int[] answer = new int[6];
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void backTraking(int count, int index){
        if (count == 6){
            for (int i : answer){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < k; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                answer[count] = num[i];
                backTraking(count + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (k == 0){
                break;
            }

            num = new int[k];
            isUsed = new boolean[k];
            for (int i = 0; i < k; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            backTraking(0, 0);
            sb.append("\n");
        }

        sb.delete(sb.length()-3, sb.length()-1);
        System.out.print(sb.toString());
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}