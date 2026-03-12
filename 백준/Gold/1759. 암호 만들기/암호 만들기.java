import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static String[] possibleString;
    static boolean[] isUsed;
    static String[] answer;
    static StringBuilder sb;
    static StringBuilder answerString = new StringBuilder();

    public static String isPossible(String password){
        int consonant = 0;
        int vowel = 0;
        for (char ch : password.toCharArray()){
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowel++;
            }
            else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2){
            return password;
        }
        return "";
    }

    public static void bTracking(int count, int index){
        if (count == L){
            sb = new StringBuilder();
            for (String s : answer){
                sb.append(s);
            }
            if (!isPossible(sb.toString()).isEmpty()){
                answerString.append(isPossible(sb.toString())).append("\n");
            }
            return;
        }

        for (int i = index; i < C; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                answer[count] = possibleString[i];
                bTracking(count + 1, i + 1);
                isUsed[i] = false;
            }
        }
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = new String[L];
        possibleString = new String[C];
        isUsed = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            possibleString[i] = st.nextToken();
        }

        Arrays.sort(possibleString);
        bTracking(0, 0);
        System.out.println(answerString.toString().trim());
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}