import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        int[] subArray = {};
        
        for (int[] row : commands){
            int start = row[0];
            int end = row[1];
            int pick = row[2];
            
            subArray = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(subArray);
            answer.add(subArray[pick-1]);
        }
        return answer;
    }
}