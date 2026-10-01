import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        // 부모 배열
        List<String> enrollList = new ArrayList<>(List.of(enroll));
        int[] parent = new int[enroll.length];
        for (int i = 0; i < referral.length; i++){
            String refer = referral[i];
            
            if (refer.equals("-")){
                parent[i] = i;
            } else {
                parent[i] = enrollList.indexOf(refer);
            }
        }
        
        // 계산
        for (int i = 0; i < seller.length; i++){
            int enrollIndex = enrollList.indexOf(seller[i]);
            int sum = amount[i]*100;
            
            while (sum > 0){
                if (enrollIndex == parent[enrollIndex]){
                    answer[enrollIndex] += sum - (sum/10);
                    // System.out.println("i: " + enrollIndex + " 추가: " + Math.round(sum*0.9));
                    break;
                }
                
                answer[enrollIndex] += sum - (sum/10);
                
                // System.out.println("i: " + enrollIndex + " 추가: " + Math.round(sum*0.9));
                
                enrollIndex = parent[enrollIndex];
                sum /= 10;
            }
            // System.out.println("다음");
        }
        return answer;
    }
}