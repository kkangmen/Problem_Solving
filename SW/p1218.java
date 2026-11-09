import java.io.*;
import java.util.Stack;

public class p1218 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            Stack<Character> s = new Stack<>();
            int answer = 1;
            // TC의 길이, 문자열 입력
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();

            // 문자열을 순회하면서
            for (char ch : str.toCharArray()){
                // (, [, {, < 중에 하나라면 스택에 push
                if (ch == '(' || ch == '[' || ch == '{' || ch == '<'){
                    s.push(ch);
                }
                // ), ], }, > 중에 하나라면
                else if ((ch == ')' && s.peek() == '(')
                || (ch == ']' && s.peek() == '[')
                || (ch == '}' && s.peek() == '{')
                || (ch == '>' && s.peek() == '<')) {
                    // 스택 탑에 있는 문자가 현재 문자와 쌍이 맞다면 pop
                    s.pop();
                }
                else {
                    // 아니라면 정답 = 0, 바로 리턴
                    answer = 0;
                    break;
                }
            }

            if (!s.isEmpty()){
                answer = 0;
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}