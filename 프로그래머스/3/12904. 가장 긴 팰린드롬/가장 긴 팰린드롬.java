class Solution
{
    public int palin(int index, String s){
        // left = index, right = index 초기화
        int left = index;
        int right = index;
        
        // left == right & left >= 0 & right < s.length()이면 계속
        while (0 <= left-1 && right+1 < s.length() && s.charAt(left-1) == s.charAt(right+1)){
            left--;
            right++;
        }
        
        // 길이 리턴
        return right-left+1;
    }
    // abba
    public int palin2(int index, String s){
        int left = index;
        int right = index+1;
        
        if (s.charAt(left) != s.charAt(right)){
            return 0;
        }
        
        // left == right & left >= 0 & right < s.length()이면 계속
        while (0 <= left-1 && right+1 < s.length() && s.charAt(left-1) == s.charAt(right+1)){
            left--;
            right++;
        }
        
        // 길이 리턴
        return right-left+1;   
    }
    
    public int solution(String s)
    {
        int answer = 0;

        // 각 자리마다
        for (int i = 0; i < s.length(); i++){
            // 좌우로 이동하여 펠린드롬일때까지 반복
            // 중앙 문자가 1일때,
            int length = palin(i, s);
            // 중앙 무자가 2개일떄, 
            
            int length2 = 0;
            if (i != s.length()-1){
                length2 = palin2(i, s);
            }
            
            // 해당 길이를 최신화
            answer = Math.max(answer, Math.max(length, length2));
        }
        return answer;
    }
}