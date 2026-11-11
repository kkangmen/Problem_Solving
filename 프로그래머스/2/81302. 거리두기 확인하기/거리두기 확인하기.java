import java.util.*;

class Solution {
    
    char[][] map = new char[5][5];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public boolean bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        // 큐에 현재 위치와 거리정보(0) 삽입
        q.offer(new int[]{x, y, 0});
        // isVisited도 생성
        boolean[][] isVisited = new boolean[5][5];
        isVisited[x][y] = true;
        // 큐가 빌때까지
        while (!q.isEmpty()){
            // 큐 poll
            int[] curNode = q.poll();
            // poll 위치의 거리가 2이내라면
            if (curNode[2] >= 2){
                continue;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !isVisited[nx][ny]){
                // 만약 새로운 위치가 'P'라면 중단 false 리턴
                    if (map[nx][ny] == 'P'){
                        return false;
                    }
                // 만약 새로운 위치가 'O'라면 큐에 삽입 (거리 1 추가)
                    if (map[nx][ny] == 'O'){
                        q.offer(new int[]{nx, ny, curNode[2]+1});
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        // 각 places마다
        for (int p = 0; p < places.length; p++){
            boolean flag = true;
            String[] place = places[p];
            // 5*5 크기 map에 삽입
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    map[i][j] = place[i].charAt(j);
                }
            }
            // 이중 for문을 통해
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                // 해당 자리가 p라면 bfs시작
                    if (map[i][j] == 'P' && !bfs(i, j)){
                        flag = false;
                        break;
                    }
                }
            }
            
            // 끝까지 완료했다면 1
            if (flag){
                answer[p] = 1;
            } else {
                answer[p] = 0;
            }
        }
        return answer;
    }
}