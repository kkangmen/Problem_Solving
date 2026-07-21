import java.util.*;

class Solution {
    
    int[] answer = new int[2];
    
    public boolean isZipable(int x, int y, int length, int[][] arr){
        int pivot = arr[x][y];
        
        for (int i = x; i < x+length; i++){
            for (int j = y; j < y+length; j++){
                if (pivot != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void dAC(int x, int y, int length, int[][] arr){
        
        if (isZipable(x, y, length, arr)){
            answer[arr[x][y]]++;
            return;
        }
        
        dAC(x, y, length/2, arr);
        dAC(x+length/2, y, length/2, arr);
        dAC(x, y+length/2, length/2, arr);
        dAC(x+length/2, y+length/2, length/2, arr);
    }
    
    public int[] solution(int[][] arr) {
        
        dAC(0, 0, arr.length, arr);
        return answer;
    }
}