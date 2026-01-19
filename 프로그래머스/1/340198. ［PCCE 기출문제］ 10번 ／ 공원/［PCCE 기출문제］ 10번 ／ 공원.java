import java.util.*;

class Solution {
    public boolean findPark(int row, int col, String[][] park, int size){
        if (row + size > park.length || col + size > park[0].length){
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
        int answer = 0;
        
        Arrays.sort(mats);
        for (int i = mats.length-1; i >= 0; i--){
            int mat = mats[i];
            
            for (int j = 0; j < park.length; j++){
                for (int k = 0; k < park[0].length; k++){
                    if (park[j][k].equals("-1")){
                        if (findPark(j, k, park, mat)){
                            answer = mat;
                            return answer;
                        }
                    }
                }
            }
        }
        return -1;
    }
}