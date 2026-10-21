// P - 앉아있는 자리
// O - 빈테이블
// X - 파티션

import java.util.*;

class Solution {
    
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public boolean bfs(int x, int y, String[] place){
        boolean flag = true;
        // isvisted 초기화
        boolean[][] isVisited = new boolean[5][5];
        // 해당 좌표와 거리 정보를 q에 담는다.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        isVisited[x][y] = true;
        
        // q가 빌 때까지
        while (!q.isEmpty()){
            // 좌표 pop
            int[] curNode = q.poll();
            // System.out.println("현재 노드: " + "x = " + curNode[0] + " y = " + curNode[1]);
            for (int i = 0; i < 4; i++){
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                int dist = curNode[2];
                
                // 거리가 2 미만이고, 
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && dist < 2){
                    // 만약 새로운 가능한 좌표가 'O'라면 큐에 넣는다.
                    if (!isVisited[nx][ny] && place[nx].charAt(ny) == 'O'){
                        isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, dist+1});
                    } 
                    // 만약 새로운 가능한 좌표가 'P'라면 중단하고 false를 리턴한다.
                    else if (!isVisited[nx][ny] && place[nx].charAt(ny) == 'P'){
                        flag = false;
                        break;                        
                    }
                }
            } 
        }
        return flag;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        // 각 places 마다
        for (int room = 0; room < places.length; room++){
            String[] place = places[room];
            // 해당 대기실을 살펴보면서
            boolean flag = true;
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < 5; j++){
                    // 해당 자리에 사람이 있다면 -> bfs 시작
                    if (place[i].charAt(j) == 'P' && !bfs(i,j, place)){
                        // System.out.println("i= " + i + " j= " + j + " 불가능");
                        flag = false;
                        break;
                    }
                }
                if (!flag){
                    break;
                }
            }  
            answer[room] = (flag == true) ? 1 : 0;
        }
                 
        return answer;
    }
}