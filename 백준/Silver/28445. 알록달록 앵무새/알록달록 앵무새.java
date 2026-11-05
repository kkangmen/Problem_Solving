
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] dad = br.readLine().split(" ");
        String[] mom = br.readLine().split(" ");

        Set<String> set = new HashSet<>();
        List<String> list = new LinkedList<>();

        for (int i = 0; i < 2; i++){
            set.add(dad[i]);
            set.add(mom[i]);
        }

        for (String s : set){
            list.add(s);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size(); j++){
                bw.write(list.get(i) + " " + list.get(j) + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
