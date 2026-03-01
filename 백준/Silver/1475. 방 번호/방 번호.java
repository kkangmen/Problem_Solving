import java.io.*;
import java.util.*;
    
public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int[] number = new int[10];
        int answer = 0;
        for (char ch : N.toCharArray()){
            int num = Integer.parseInt(String.valueOf(ch));

            if (num == 6 || num == 9){
                if (number[6] < number[9]){
                    number[6]++;
                }
                else {
                    number[9]++;
                }
            }
            else {
                number[num]++;
            }
        }

        for (int i : number){
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }
    public static void main(String[] args) throws IOException {
        solution();
    }
}