import java.util.*;
import java.io.*;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        List<String> list = new ArrayList<>();

        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < n; i++){
            String str1 = br.readLine();
            visited.add(str1);
        }

        for (int i = 0; i < m; i++){
            String str2 = br.readLine();
            if (visited.contains(str2)){
                list.add(str2);
                cnt++;
            }
        }

        Collections.sort(list);
        bw.write(cnt+"\n");
        for (String str : list){
            bw.write(str+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}