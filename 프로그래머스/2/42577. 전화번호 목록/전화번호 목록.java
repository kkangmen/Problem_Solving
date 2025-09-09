import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for (int i = 1; i < phone_book.length; i++){
            String s1 = phone_book[i-1];
            String s2 = phone_book[i];
            if (s2.startsWith(s1)){
                answer = false;
            }
        }
        return answer;
    }
}