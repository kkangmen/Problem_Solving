import java.util.*;

class Solution {
    class File {
        String head;
        int number;
        String origin;
        File (String head, int number, String origin){
            this.head = head;
            this.number = number;
            this.origin = origin;
        }
    }
    
    List<File> orderFileList = new ArrayList<>();
    
    public List<String> solution(String[] files) {
        List<String> answer = new ArrayList<>();
        
        for (String s : files){
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            boolean change = false;
            
            for (char ch : s.toCharArray()){
                if ((ch < '0' || ch > '9') && !change){
                    head.append(String.valueOf(ch));
                    continue;
                }
                
                if ((ch >= '0' && ch <= '9')){
                    change = true;
                    number.append(String.valueOf(ch));
                } else {
                    break;
                }
            }
            orderFileList.add(new File(head.toString().toLowerCase(), Integer.parseInt(number.toString()), s));
            // System.out.println(head.toString().toLowerCase());
            // System.out.println(Integer.parseInt(number.toString()));
            // System.out.println(s);
        }
        
        Collections.sort(orderFileList, (o1, o2) -> {
            if (o1.head.equals(o2.head)){
                return o1.number - o2.number;
            }
            return o1.head.compareTo(o2.head);
        });
        
        for (File f : orderFileList){
            answer.add(f.origin);
        }
        return answer;
    }
}