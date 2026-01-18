import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        
        for (String s : cards1){
            queue1.offer(s);
        }
        for (String s : cards2){
            queue2.offer(s);
        }
        
        Boolean canMake = true;
        for (String s : goal){
            if(!queue1.isEmpty() && queue1.peek().equals(s)){
                queue1.poll();
                continue;
            }
            if(!queue2.isEmpty() && queue2.peek().equals(s)){
                queue2.poll();
                continue;
            }
            canMake = false;
            break;
        }
        
        if (canMake){
            answer = "Yes";
        }
        else {
            answer = "No";
        }
        return answer;
    }
}