import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        while (left <= right){
            int rightPerson = people[right];
            int leftPerson = people[left];
            
            if (rightPerson+leftPerson > limit){
                right--;
            }
            else {
                right--;
                left++;
            }
            answer++;
        }
        return answer;
    }
}

// 30 40 50 60 70
// 10 30 80 80 90