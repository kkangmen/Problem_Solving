import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int sum = 0;
        int idx = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '*'){
                idx = i;
                continue;
            }

            if (i % 2 == 0){
                sum += Integer.parseInt(String.valueOf((s.charAt(i))));
            }
            else {
                sum += Integer.parseInt(String.valueOf((s.charAt(i)))) * 3;
            }
        }

        int answer = 0;
        while(true){
            if (idx % 2 == 0){
                if ((sum + answer) % 10 == 0){
                    System.out.println(answer);
                    break;
                }
            }
            else {
                if ((sum + answer * 3) % 10 == 0){
                    System.out.println(answer);
                    break;
                }
            }
            answer++;
        }
    }
}
