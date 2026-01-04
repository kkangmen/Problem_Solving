// import java.util.*;

// // integer.parseint(int number, int 진법)
// class Solution {
//     public List<String> solution(int n, int[] arr1, int[] arr2) {
//         List<String> answer = new ArrayList<>();
//         StringBuilder sb = new StringBuilder();
        
//         for (int i = 0; i < n; i++){
//             int num1 = arr1[i];
//             int num2 = arr2[i];
            
//             String s1 = decToBin(num1, n);
//             String s2 = decToBin(num2, n);
            
            
//             for (int j = 0; j < n; j++){
//                 char c1 = s1.charAt(j);
//                 char c2 = s2.charAt(j);
                
//                 if (c1 == '0' && c2 == '0'){
//                     sb.append(" ");
//                 }
//                 else {
//                     sb.append("#");
//                 }
//             }
            
//             answer.add(sb.toString());
//             sb.delete(0, sb.length());
//         }
//         return answer;
//     }
    
//     public String decToBin(int num, int n){
//         StringBuilder sb = new StringBuilder();
        
//         while (num > 0){
//             sb.append(num%2);  // 1 0 0 1
//             num /= 2;       // 4 2 1
//         }
        
//         while (sb.length() < n){
//             sb.append(0);
//         }
        
//         return sb.reverse().toString();
//     }
// }

class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}