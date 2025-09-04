import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0){
                if (pq.isEmpty()){
                    bw.write(0 + "\n");
                }
                else {
                    bw.write(pq.poll() + "\n");
                    }
            }
            
            else {
                pq.offer(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}