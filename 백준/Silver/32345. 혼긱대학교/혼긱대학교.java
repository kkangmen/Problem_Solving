import java.io.*;
import java.util.*;

public class Main {
    static int mod = 1000000007;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            String s = br.readLine();

            long answer = 1;
            int lastVowelIndex = -1;
            boolean canAnswer = false;

            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' ||
                        s.charAt(j) == 'o' || s.charAt(j) == 'u'){
                    if (!canAnswer){
                        canAnswer = true;
                    }
                    if (lastVowelIndex != -1){
                        answer *= (j - lastVowelIndex);
                    }
                    lastVowelIndex = j;
                }
                answer %= mod;
            }
            if (!canAnswer){
                bw.write(-1 + "\n");
            }
            else {
                bw.write(answer + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
