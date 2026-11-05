import java.util.*;

class Solution {
    
    public boolean isCompactable(int x, int y, int length, int[][] arr){
        for (int i = x; i < x+length; i++){
            for (int j = y; j < y+length; j++){
                if (arr[x][y] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void dfs(int x, int y, int length, int[][] arr, int[] answer){
        if (isCompactable(x, y, length, arr)){
            if (arr[x][y] == 0){
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }
        
        dfs(x, y, length/2, arr, answer);
        dfs(x, y+length/2, length/2, arr, answer);
        dfs(x+length/2, y, length/2, arr, answer);
        dfs(x+length/2, y+length/2, length/2, arr, answer);
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        dfs(0, 0, arr.length, arr, answer);
        return answer;
    }
}