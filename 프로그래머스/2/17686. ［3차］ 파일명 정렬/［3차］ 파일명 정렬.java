import java.util.*;

class Solution {
    
    class File {
        String originalName;
        String head;
        String number;
        
        File (String originalName, String head, String number){
            this.originalName = originalName;
            this.head = head;
            this.number = number;
        }
    }
    
    
    public List<String> solution(String[] files) {
        List<String> answer = new ArrayList<>();
        List<File> list = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++){
            String fileName = files[i];
            
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            int index = 0;
            int maxIndex = fileName.length();
            
            while (index < maxIndex && (fileName.charAt(index) < '0' || fileName.charAt(index) > '9')){
                head.append(String.valueOf(fileName.charAt(index)));
                index++;
            }
            
            int numCount = 0;
            while (index < maxIndex && '0' <= fileName.charAt(index) && fileName.charAt(index) <= '9' && numCount < 5){
                number.append(String.valueOf(fileName.charAt(index)));
                index++;
                numCount++;
            }
            
            // System.out.println("head= "+ head.toString().toLowerCase());
            // System.out.println("number= "+ Integer.parseInt(number.toString()));
            
            list.add(new File(fileName, head.toString(), number.toString()));
        }
        
        Collections.sort(list, (File o1, File o2) -> {
           if (o1.head.toLowerCase().equals(o2.head.toLowerCase())){
               return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
           }
        
            return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
        });
        
        for (File f : list){
            String head = f.head;
            String number = f.number;
            
            answer.add(f.originalName);
        }
        return answer;
    }
}