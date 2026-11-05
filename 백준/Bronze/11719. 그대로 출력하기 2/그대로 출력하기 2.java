import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1;

        while(true){
            str1 = br.readLine();
            if ((str1 == null)){
                break;
            }
            bw.write(str1);
            bw.newLine();
        }


        br.close();
        bw.flush();
        bw.close();
    }
}