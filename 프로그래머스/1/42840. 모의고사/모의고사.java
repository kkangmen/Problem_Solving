import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new LinkedList<>();
        
        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] total = new int[3];
        
        int i = 0, j = 0, k = 0;
        for (int index : answers){
            if (index == num1[i]){
                total[0]++;
            }
            if (index == num2[j]){
                total[1]++;
            }
            if (index == num3[k]){
                total[2]++;
            }
            
            i++;
            j++;
            k++;
            if (i == 5){
                i = 0;
            }
            if (j == 8){
                j = 0;
            }
            if (k == 10){
                k = 0;
            }
        }
        
        int max = 0;
        for (int num : total){
            max = Math.max(max, num);
        }
        
        for (int num = 0; num < 3; num++){
            if (total[num] == max){
                answer.add(num+1);
            }
        }
        return answer;
    }
}