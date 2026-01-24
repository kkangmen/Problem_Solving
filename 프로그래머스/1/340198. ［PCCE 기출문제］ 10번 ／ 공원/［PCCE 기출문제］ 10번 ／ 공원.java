import java.util.*;

class Solution {
    public boolean canFit(int row, int col, String[][] park, int size){
        if (row+size > park.length || col+size > park[0].length){
            return false;
        }
            
        for (int i = row; i < row+size; i++){
            for (int j = col; j < col+size; j++){
                if (!park[i][j].equals("-1")){
                    return false;
                }
            }
        }  
        return true;
    }
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        
        int parkRow = park.length;
        int parkCol = park[0].length;
        
        for (int i = 0; i < parkRow; i++){
            for (int j = 0; j < parkCol; j++){
                if(park[i][j].equals("-1")){
                    for (int k = 0; k < mats.length; k++){
                        if(canFit(i, j, park, mats[k])){
                            answer = Math.max(answer, mats[k]);
                        }
                    }
                }        
            }
        }
        
        if (answer == -1){
            return -1;
        }
        return answer;
    }
}
// 50*50*10*20*20 = 25000*400 = 10,000,000