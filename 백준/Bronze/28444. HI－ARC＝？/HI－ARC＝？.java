
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]) * Integer.parseInt(input[3]) * Integer.parseInt(input[4]);

        bw.write(a-b + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
