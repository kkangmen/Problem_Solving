import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // phone_book을 오름차순으로 정렬
        Arrays.sort(phone_book);
        
        // 배열을 순회하면서, 다음 인덱스가 현재 인덱스로 시작하면
        // false 반환하고 break;
        for (int i = 0; i < phone_book.length-1; i++){
            String curPhone = phone_book[i];
            String nxtPhone = phone_book[i+1];
            
            if (nxtPhone.startsWith(curPhone)){
                return false;
            }
        }
        return answer;
    }
}