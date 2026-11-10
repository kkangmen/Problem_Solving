import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1225 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            // tc 입력
            int tc = Integer.parseInt(br.readLine());
            // 8자리 암호 배열 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[8];
            for (int i = 0; i < 8; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 큐에 집어넣기
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 8; i++){
                q.offer(arr[i]);
            }
            // n=1
            int val = 1;
            // 큐.peek에서 해당 번호(n)를 뺐는데 0보다 작지 않다면 지속
            while (!q.isEmpty() && q.peek() - val > 0) {
                // 큐.peek하고 해당 사이클의 숫자(n)를 빼고 큐.offer()
                q.offer(q.poll()-val);
                // n++
                val++;
                // 만약 n=6번째라면, 새로운 사이클 시작 n=1
                if (val == 6){
                    val = 1;
                }
            }

            q.poll();
            q.offer(0);

            System.out.print("#" + test_case + " ");
            while (!q.isEmpty()){
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }
    }
}