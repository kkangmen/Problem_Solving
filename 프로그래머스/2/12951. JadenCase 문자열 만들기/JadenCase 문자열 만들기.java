class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char prevChar = 'f';
        for (char ch: s.toCharArray()){
            if ('0' <= ch && ch <= '9'){
                prevChar = 'x';
            }
            else if (ch == ' '){
                prevChar = ' ';
            }
            else {
                if (prevChar == ' ' || prevChar == 'f'){
                    ch = Character.toUpperCase(ch);
                    prevChar = 'x';
                }
                else {
                    ch = Character.toLowerCase(ch);
                }
            }
            sb.append(String.valueOf(ch));
        }
        return sb.toString();
    }
}