import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class p1234 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            Stack<Character> s = new Stack<>();

            // 문자의 총 수와 비밀번호 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String pw = st.nextToken();

            // 비밀번호 순회하면서
            for (char ch : pw.toCharArray()) {
                // 만약 스택이 비어있지않고, peek와 현재가 같다면 pop
                if (!s.isEmpty() && s.peek() == ch) {
                    s.pop();
                }
                // 스택에 push
                else {
                    s.push(ch);
                }
            }

            // sb로 스택 전부 pop => answer
            StringBuilder answer = new StringBuilder();
            while (!s.isEmpty()){
                answer.append(s.pop());
            }

            System.out.println("#" + test_case + " " + answer.reverse().toString());
        }
    }
}