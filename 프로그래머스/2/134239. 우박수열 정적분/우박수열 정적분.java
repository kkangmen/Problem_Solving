import java.util.*;

class Solution {
    
    List<Double> width = new ArrayList<>();
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        int n = k;
        while (k != 1){
            int up = k;
            if (up % 2 == 0){
                k /= 2;
            } else {
                k = k*3 + 1;
            }
            
            int down = k;
            
            // 사다리꼴 넓이
            width.add((up+down)/(double)2);
        }
                
        // for (double d : width){
        //     System.out.print(d+" ");
        // }
        
        for (int i = 0; i < ranges.length; i++){
            int start = ranges[i][0];
            int end = width.size() + ranges[i][1];
            
            // 유효하지 않은 구간일 경우
            if (start > end){
                answer[i] = -1.0;
            } else if (start == end){
                answer[i] = 0.0;
            } else {
                double sum = 0;
                for (int j = start; j < end; j++){
                    sum += width.get(j);
                }
                answer[i] = sum;
            }
        }
        
        return answer;
    }
}