import java.util.*;
import java.io.*;

class Solution {
	
	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static int[] distance;
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		distance[start] = 0;
		
		while (!q.isEmpty()) {
			int curNode = q.poll();
			for (int i = 0; i < graph.get(curNode).size(); i++) {
				int nxtNode = graph.get(curNode).get(i);
				if (distance[nxtNode] == -1) {
					distance[nxtNode] = distance[curNode] + 1;
					q.offer(nxtNode);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			// 데이터 길이, 시작점 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			// HashMap<Integer, Set<>> 선언 후 값 입력
			for (int i = 1; i <= 100; i++) {
				graph.put(i, new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
			}
			distance = new int[101];
			Arrays.fill(distance, -1);
			// 시작점에서 부터 bfs 시작
			bfs(start);
			// 거리가 가장 큰 것 들 중에 번호가 가장 큰 것이 정답
			int answer = 0;
			int maxDist = 0;
			for (int i = 1; i <= 100; i++) {
				if (maxDist <= distance[i]) {
					maxDist = distance[i];
					answer = i;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}