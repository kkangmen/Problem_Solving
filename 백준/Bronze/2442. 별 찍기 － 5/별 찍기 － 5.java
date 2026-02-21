
import java.io.*;
import java.util.*;
    
public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++){
            int last = 2*n-1; // 9

            // 왼쪽 공백
            for (int j = (last-1)/2-(i-1); j > 0 ; j--){
                bw.write(" ");
            }

            // 별 출력
            for (int j = 2*i-1; j > 0; j--){
                bw.write("*");
            }

            // 오른쪽 공백
//            for (int j = (last-1)/2-(i-1); j > 0 ; j--){
//                bw.write(" ");
//            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}