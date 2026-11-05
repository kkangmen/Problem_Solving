class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int curBottle = n;
        while (curBottle >= a){
            int get = curBottle/a*b; // 6 2 1
            int rem = curBottle%a; // 2   2 1 
            
            int total = get+rem;
            curBottle = total;
            answer += get;
        }
        return answer;
    }
}