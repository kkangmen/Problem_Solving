import java.util.*;

class Solution {
    
    static int[] answer = new int[2];
    
    public boolean chkQuad(int[][] arr, int x, int y, int length){
        for (int i = x; i < x+length; i++){
            for (int j = y; j < y+length; j++){
                if (arr[i][j] != arr[x][y]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void srcQuad(int[][] arr, int x, int y, int length){
        if (chkQuad(arr, x, y, length)){
            if (arr[x][y] == 0){
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }
        
        srcQuad(arr, x, y, length/2);
        srcQuad(arr, x+length/2, y, length/2);
        srcQuad(arr, x, y+length/2, length/2);
        srcQuad(arr, x+length/2, y+length/2, length/2);
    }
    
    public int[] solution(int[][] arr) {
        
        srcQuad(arr, 0, 0, arr.length);
        
        return answer;
    }
}