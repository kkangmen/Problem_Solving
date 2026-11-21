import java.util.*;
import java.io.*;

class Solution {
	
	static int[] gyuYoung = new int[9];
	static int[] inYoung = new int[9];
	static boolean[] isUsed;
	static int[] answer;
	
	public static void bTracking(int idx, int gyuSum, int inSum) {
		// 만약 idx가 9가 되면 비교 후 리턴
		if (idx == 9) {
			if (gyuSum > inSum) {
				answer[0]++;
			} else if (gyuSum < inSum) {
				answer[1]++;
			}
			return;
		}
		// 0부터 시작해서
		for (int i = 0; i < 9; i++) {
			// 사용되지 않았다면 배열에 추가하고 true로 바꿈
			if (!isUsed[i]) {
				isUsed[i] = true;
				if (gyuYoung[idx] > inYoung[i]) {
					bTracking(idx+1, gyuSum + gyuYoung[idx] + inYoung[i], inSum);
				} else if (gyuYoung[idx] < inYoung[i]) {
					bTracking(idx+1, gyuSum, inSum + gyuYoung[idx] + inYoung[i]);
				}
				isUsed[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// T 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		// tc 동안
		for (int test_case = 1; test_case <= T; test_case++) {
			boolean[] numUsed = new boolean[19];
			// 규영이의 숫자 배열 (9크기) 선언 및 입력 + 숫자 사용 표시
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				gyuYoung[i] = num;
				numUsed[num] = true;
			}
			// 사용하지 않은 숫자를 인영이의 숫자 배열로 입력
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!numUsed[i]) {
					inYoung[idx++] = i;
				}
			}
			// 백트래킹
			isUsed = new boolean[9];
			answer = new int[2];
			bTracking(0, 0, 0);
			// pring
			System.out.println("#" + test_case + " " + answer[0] + " " + answer[1]);
		}
	}
}