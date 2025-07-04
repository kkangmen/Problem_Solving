import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char ch = br.readLine().charAt(0);
//        int ans = (int)ch;
//
//        bw.write(String.valueOf(ans));

        bw.write(String.valueOf((int)ch));
        br.close();
        bw.flush();
        bw.close();
    }
}