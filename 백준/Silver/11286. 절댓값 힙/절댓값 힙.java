import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Info> pq = new PriorityQueue<>();

    public static class Info implements Comparable<Info>{
        int num;
        Info (int num, int index){
            this.num = num;
        }

        @Override
        public int compareTo(Info o){
            if (Math.abs(this.num) == Math.abs(o.num)){
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(Math.abs(this.num), Math.abs(o.num));
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int index = 0;

        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if (x == 0){
                if (pq.isEmpty()){
                    bw.write(0 + "\n");
                }
                else {
                    bw.write(pq.poll().num + "\n");
                }
            }
            else {
                pq.offer(new Info(x, index));
                index++;
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