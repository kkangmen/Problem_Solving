class Solution {
    public String solution(String[] survey, int[] choices) {
        
        char[][] index = {{'R', 'T'},
                          {'C', 'F'},
                          {'J', 'M'},
                          {'A', 'N'}};
        
        StringBuilder sb = new StringBuilder();
        
        int[] alphabet = new int['Z' - 'A'+1];
        
        for (int i = 0; i < choices.length; i++){
            if (choices[i] > 4){
                alphabet[survey[i].charAt(1)-'A'] += choices[i] - 4;
            }
            else if (choices[i] < 4){
                alphabet[survey[i].charAt(0)-'A'] += 4 - choices[i];
            }
        }
        
        for (char[] character: index){
            char c1 = character[0];
            char c2 = character[1];
            char c3 = 'a';
            if (alphabet[c1-'A'] == alphabet[c2-'A']){
                c3 = c1 > c2 ? c2 : c1;
            }
            else {
                c3 = alphabet[c1-'A'] > alphabet[c2-'A'] ? c1 : c2;
            }
            
            sb.append(String.valueOf(c3));
        }
        
        return sb.toString();
    }
}