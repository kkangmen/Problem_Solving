import java.util.*;
import java.io.*;

public class Main {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1){
                int x  = Integer.parseInt(st.nextToken());
                stack.push(x);
                cnt++;
            }
            else if (order == 2){
                if (!stack.empty()){
                    bw.write(String.valueOf(stack.pop()));
                    bw.newLine();
                    cnt--;
                }
                else{
                    bw.write("-1");
                    bw.newLine();
                }
            }
            else if (order == 3){
                bw.write(String.valueOf(cnt));
                bw.newLine();
            }
            else if (order == 4){
                if (stack.empty()){
                    bw.write("1");
                    bw.newLine();
                }
                else {
                    bw.write("0");
                    bw.newLine();
                }
            }
            else if (order == 5){
                if (!stack.empty()){
                    bw.write(String.valueOf(stack.peek()));
                    bw.newLine();
                }
                else {
                    bw.write("-1");
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}