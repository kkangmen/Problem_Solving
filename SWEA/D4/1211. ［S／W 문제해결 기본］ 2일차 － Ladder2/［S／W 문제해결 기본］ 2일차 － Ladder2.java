import java.util.*;
import java.io.*;

class Solution{
	
	static int[][] map;
	static int moveCnt;
	static int answer;
	
	public static int move(int row, int col, int cnt) {
		// 만약  row가 100이면 return;
		if (row == 99) {
			return cnt;
		}
		// 만약 왼쪽에 1이 있다면, 1일 경우 || 열이 1이상이면 계속 
		if (col >= 1 && map[row][col-1] == 1) {
			while (col >= 1 && map[row][col-1]==1) {
				cnt+=1;
				col-=1;
			}
		}
		// 다른 만약 오른쪽에 1이 있다면, 1일 경우 || 열이 99이하면 계속
		else if (col <= 98 && map[row][col+1] == 1) {
			while (col <= 98 && map[row][col+1] == 1) {
				cnt+=1;
				col+=1;
			}
		}
		// 밑으로 이동
		return move(row +1, col, cnt+1);
	}
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			answer = 0;
			moveCnt = Integer.MAX_VALUE;
			// tc 입력 및 100*100 배열 생성 + 저장
			int tc = Integer.parseInt(br.readLine());
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 배열의 [0][i]를 순회하면서 1이면 출발
//			System.out.println("test_case: " + test_case);
			for (int j = 0; j < 100; j++) {
//				System.out.println("j: " + j);
				if (map[0][j] == 1) {
					int cnt = move(0, j, 0);
					if (moveCnt > cnt) {
						moveCnt = cnt;
						answer = j;
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}