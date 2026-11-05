import java.util.*;
import java.io.*;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        int ans = Integer.MAX_VALUE;

        String[] splitStrArr = str1.split("-");

        for (int i = 0; i < splitStrArr.length; i++){
            int temp =0;

            String [] addition = splitStrArr[i].split("\\+");

            for (int j = 0; j < addition.length; j++){
                temp += Integer.parseInt(addition[j]);
            }

            if (ans == Integer.MAX_VALUE){
                ans = temp;
            }
            else {
                ans -= temp;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}