import java.util.*;

class Solution {
    
    class Info {
        String head;
        String number;
        String fileName;
        Info (String h, String n, String f){
            this.head = h;
            this.number = n;
            this.fileName = f;
        }
    }
    
    List<Info> list = new LinkedList<>();
    
    public List<String> solution(String[] files) {
        List<String> answer = new LinkedList<>();
        
        for (String file : files){
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            int index = 0;
            while (file.charAt(index) < '0' || file.charAt(index) > '9'){
                head.append(String.valueOf(file.charAt(index)));
                index++;
            }
            
            int maxCnt = 0;
            while (index < file.length() && (file.charAt(index) >= '0' && file.charAt(index) <= '9') && maxCnt <= 5){
                number.append(String.valueOf(file.charAt(index)));
                index++;
                maxCnt++;
            }
            
            list.add(new Info(head.toString(), number.toString(), file));
        }
        
        Collections.sort(list, (Info o1, Info o2) -> {
            String s1 = o1.head.toLowerCase(); 
            String s2 = o2.head.toLowerCase(); 
            if (s1.equals(s2)){
                return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
            }
           return s1.compareTo(s2);
        });
        
        for (Info i : list){
            answer.add(i.fileName);
        }
        return answer;
    }
}