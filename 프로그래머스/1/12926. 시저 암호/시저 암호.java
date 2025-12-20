import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if (c >= 'a' && c <= 'z'){
                if (c + n > 'z'){
                    c = (char)('a' + (c+n-'z') -1);
                    sb.append(String.valueOf(c));
                }
                else {
                    sb.append((char)(c+n));
                }
            }
            else if (c >= 'A' && c <= 'Z'){
                if (c + n > 'Z'){
                    c = (char)('A' + (c+n-'Z')-1);
                    sb.append(String.valueOf(c));
                }
                else {
                    sb.append((char)(c+n));
                }
            }
            else {
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}