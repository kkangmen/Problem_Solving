import java.util.*;

class Solution {
    
    List<int[]> rows = new ArrayList<>();
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        StringBuilder answer = new StringBuilder();
        
        for (int[] oneData : data){
            rows.add(oneData);
        }
        
        Collections.sort(rows, (o1, o2) -> {
           if (o1[col-1] == o2[col-1]){
               return o2[0] - o1[0];
           } 
            return o1[col-1] - o2[col-1];
        });
        
        List<Integer> moduler = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++){
            int[] row = rows.get(i-1);
            // System.out.println(row[0] + " " + row[1] + " " + row[2]);
            int sum = 0;
            for (int j = 0; j < row.length; j++){
                sum += row[j]%i;
            }
            // System.out.println(sum);
            moduler.add(sum);
        }
        
        // for (int i : moduler){
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        
        // XOR 연산
        String binary = Integer.toString(moduler.get(0), 2);
        for (int i = 1; i < moduler.size(); i++){
            // 1. 두 수를 모두 2진수로 변환
            String num2 = Integer.toString(moduler.get(i), 2);
            
            // 2. 길이를 맞추고
            int maxLen = Math.max(binary.length(), num2.length());
            int binaryLen = binary.length();
            int num2Len = num2.length();
            for (int j = 0; j < maxLen - binaryLen; j++){
                binary = "0" + binary;
            }
            for (int j = 0; j < maxLen - num2Len; j++){
                num2 = "0" + num2;
            }
            // System.out.println(binary + " " + num2);
            
            // 3. XOR 연산
            String temp = "";
            for (int j = 0; j < maxLen; j++){
                char ch1 = binary.charAt(j);
                char ch2 = num2.charAt(j);
                
                if (ch1 == ch2){
                    temp += "0";
                } else {
                    temp += "1";
                }
            }
            
            binary = temp;
            // System.out.println("binary = " + binary);
        }
        
        // int a = Integer.parseInt(answer.toString(), 2);
        // System.out.println(a);
        // for (int[] row : rows){
        //     System.out.println(row[0] + " " + row[1] + " " + row[2]);
        // }
        return Integer.parseInt(binary, 2);
    }
}