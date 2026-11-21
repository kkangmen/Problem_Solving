import java.util.*;
import java.io.*;

class Solution {
	static int[] operand = new int[4];
	static int[] operator;
	static int[] result;
	static int N;
	static int min;
	static int max;
	public static int calculate() {
		int sum = operator[0];
		for (int i = 1; i < N; i++) {
			int op = result[i-1];
			int right = operator[i];
			if (op == 0) {
				sum += right;
			} else if (op == 1) {
				sum -= right;
			} else if (op == 2) {
				sum *= right;
			} else {
				sum /= right;
			}
		}
		return sum;
	}
	public static void bTracking(int cnt) {
		// cnt가 N-1이 되면 계산 후 리턴
		if (cnt == N-1) {
			int temp = calculate();
			if (max < temp) {
				max = temp;
			}
			if (min > temp) {
				min = temp;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operand[i] > 0) {
				operand[i] -= 1;
				result[cnt] = i;
				bTracking(cnt+1);
				operand[i] += 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// T 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// tc동안
		for (int test_case = 1; test_case <= T; test_case++) {
			// N (숫자의 개수) 입력
			N = Integer.parseInt(br.readLine());
			operator = new int[N];
			// 연산자의 개수 입력 [4]
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operand[i] = Integer.parseInt(st.nextToken());
			}
			// N 배열에 숫자 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			// 백트래킹
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			result = new int[N-1];
			bTracking(0);
			int answer = max-min;
			System.out.println("#" + test_case + " " + answer);
		}
	}
}