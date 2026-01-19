import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletMaxLength = Math.max(wallet[0], wallet[1]);
        int walletMinLength = Math.min(wallet[0], wallet[1]);
        
        int billMaxLength = Math.max(bill[0], bill[1]);
        int billMinLength = Math.min(bill[0], bill[1]);
        while (billMaxLength > walletMaxLength || billMinLength > walletMinLength){
            answer++;
            
            billMaxLength /= 2;
            
            int tempMax = Math.max(billMaxLength, billMinLength);
            int tempMin = Math.min(billMaxLength, billMinLength);
            
            billMaxLength = tempMax;
            billMinLength = tempMin;
        }
        return answer;
    }
}