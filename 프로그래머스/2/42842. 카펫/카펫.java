import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        List<Integer> suspect = new ArrayList<>();
        
        for (int i = 1; i <= total; i++){
            if (total % i == 0){
                suspect.add(i);
            }
        }
        
        // for (int i = 0; i < suspect.size(); i++){
        //     System.out.print(suspect.get(i)+" ");
        // }
        // System.out.println();
        
        int left = 0;
        int right = suspect.size()-1;
        while (left <= right){
            // System.out.println(left + " " + right);
            
            int width = suspect.get(right);
            int height = suspect.get(left);
            
            if ((width-2)*(height-2) == yellow){
                answer[0] = width;
                answer[1] = height;
                break;
            }
            
            left++;
            right--;
        }
        return answer;
    }
}