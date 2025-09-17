
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Integer> map = new HashMap<>();

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++){
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (array[0] == 1){
                map.put(array[2], array[1]);
            }
            else{
                bw.write(map.get(array[1]) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
