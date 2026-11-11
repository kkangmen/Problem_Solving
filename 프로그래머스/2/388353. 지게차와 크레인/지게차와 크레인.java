import java.util.*;

class Solution {
    
    char[][] map;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int row = 0; int col = 0;
    
    public void bfs(char ch){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[row+2][col+2];
        // (0,0) 삽입
        q.offer(new int[]{0,0});
        isVisited[0][0] = true;
        
        // 큐가 빌 때까지
        while (!q.isEmpty()){
            int[] curNode = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = curNode[0] + dx[i];
                int ny = curNode[1] + dy[i];
                
                if (0 <= nx && nx < row+2 && 0 <= ny && ny < col+2){
                    // 만약 '-'라면 큐에 추가
                    if (map[nx][ny] == '-' && !isVisited[nx][ny]){
                        isVisited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                    // 만약 '찾는 문자라면' 해당 칸을 '-'로 바꾼다.
                    if (map[nx][ny] == ch && !isVisited[nx][ny]){
                        isVisited[nx][ny] = true;
                        map[nx][ny] = '-';
                    }
                }
            }
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        row = storage.length;
        col = storage[0].length();
        // map 선언 및 storage를 map에 삽입
        // 이때 크기 1 패딩을 추가한다.
        map = new char[row+2][col+2];
        for (int i = 0; i < row+2; i++){
            for (int j = 0; j < col+2; j++){
                if (i == 0 || j == 0 || i == row+1 || j == col+1){
                    map[i][j] = '-';
                } else {
                    map[i][j] = storage[i-1].charAt(j-1);
                }
            }
        }
        
        // 각 request 마다
        for (String request : requests){
            // 만약 한글자라면
            if (request.length() == 1){
                // (0,0)부터 bfs 시작
                bfs(request.charAt(0));
            } else {
            // 만약 두 글자라면
                // map 전체 순회하여 해당 문자를 전부 '-'로 바꿈.
                for (int i = 1; i < row+1; i++){
                    for (int j = 1; j < col+1; j++){
                        if (map[i][j] == request.charAt(0)){
                            map[i][j] = '-';
                        }
                    }
                }
            }
            
            // 출력
            // for (int i = 0; i < row+2; i++){
            //     for (int j = 0; j < col+2; j++){
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.out.println();
            // }
        }
        // 최종적으로 '-'가 아닌 갯수가 정답
        for (int i = 0; i < row+2; i++){
            for (int j = 0; j < col+2; j++){
                if (map[i][j] != '-'){
                    answer++;
                }
            }
        }
        return answer;
    }
}