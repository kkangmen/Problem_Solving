import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hiarc = new int[5];

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case 'H':
                    hiarc[0]++;
                    break;
                case 'I':
                    hiarc[1]++;
                    break;
                case 'A':
                    hiarc[2]++;
                    break;
                case 'R':
                    hiarc[3]++;
                    break;
                case 'C':
                    hiarc[4]++;
                    break;
                default :
                    break;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++){
            ans = Math.min(ans, hiarc[i]);
        }
        System.out.println(ans);
    }
}
