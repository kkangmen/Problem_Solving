import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<String> dataAttribute = List.of("code", "date", "maximum", "remain");
        
        int colNum = dataAttribute.indexOf(ext);
        List<int[]> satisfy = new ArrayList<>();
        
        for (int[] i : data){
            if (i[colNum] < val_ext){
                satisfy.add(i);
            }
        }
        
        int sortNum = dataAttribute.indexOf(sort_by);
        Collections.sort(satisfy, (a, b) -> {
            return a[sortNum] - b[sortNum];
        });
        
        
        // Iterator<int[]> iter = satisfy.iterator();
        // while (iter.hasNext()){
        //     int[] k = iter.next();
        //     System.out.print(k[0]);
        // }
        return satisfy;
    }
}