class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        int curCount = 1;
        while (curCount <= count){
            long curPrice = price * curCount;
            curCount++;
            answer += curPrice;
        }
        
        if (answer <= money){
            answer = 0;
        }
        else {
            answer = (long)answer - money;
        }
        return answer;
    }
}