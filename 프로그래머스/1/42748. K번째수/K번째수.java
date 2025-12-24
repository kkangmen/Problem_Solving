import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++){
            int[] row = commands[i];
            
            int start = row[0];
            int end = row[1];
            int index = row[2];
            
            int[] subArray = {};
            subArray = Arrays.copyOfRange(array, start-1, end);
            
            Arrays.sort(subArray);
            answer.add(subArray[index-1]);
            
            // 출력
            // for (int j : subArray){
            //     System.out.print(j + " ");
            // }
            // System.out.println();
        }
        return answer;
    }
}