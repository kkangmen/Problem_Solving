import java.io.*;

public class p1215 {

    public static boolean isTrue(String word){
        // word 길이를 2로 나눠서
        // 0부터 word/2까지
        for (int i = 0; i < word.length()/2; i++) {
            // i와 word-i가 다르면 false 반환
            if (word.charAt(i) != word.charAt(word.length()-1 - i)) {
                return false;
            }
        }

//        System.out.println("회문: " + word);
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            int answer = 0;

            // N (회문의 길이)
            int N = Integer.parseInt(br.readLine());

            // 8*8 배열 생성 및 값 채우기
            char[][] map = new char[8][8];
            for (int i = 0; i < 8; i++){
                String line = br.readLine();
                for (int j = 0; j < 8; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            // 가로 탐색 (0부터 N까지)
            for (int i = 0; i < 8; i++) {
                // 열 (0부터 8-N까지)
                for (int j = 0; j <= 8 - N; j++) {
                    // 해당 지점에서 N만큼 sb 추가
                    for (int k = j; k < j + N; k++) {
                        sb.append(map[i][k]);
                    }
//                    System.out.println("순회: " + sb.toString());
                    // 회문이면 answer+= 1
                    if (isTrue(sb.toString())) {
                        answer += 1;
                    }
                    sb.setLength(0);
                }
            }
//            System.out.println("열 탐색 시작");
            // 열 탐색 (0부터 N까지)
            for (int i = 0; i < 8; i++) {
                // 행 (0부터 8-N까지)
                for (int j = 0; j <= 8 - N; j++) {
                    // 해당 지점에서 N만큼 sb 추가
                    for (int k = j; k < j + N; k++) {
                        sb.append(map[k][i]);
                    }
                    // 회문이면 answer+= 1
                    if (isTrue(sb.toString())) {
                        answer += 1;
                    }
                    sb.setLength(0);
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}