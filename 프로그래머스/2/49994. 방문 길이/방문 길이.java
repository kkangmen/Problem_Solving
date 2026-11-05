import java.util.*;

class Solution {
    class Point{
        private int prevX, prevY, curX, curY;
        public Point(int prevX, int prevY, int curX, int curY){
            this.prevX = prevX;
            this.prevY = prevY;
            this.curX = curX;
            this.curY = curY;
        }
        
        public int hashCode(){
            return prevX + prevY + curX + curY;
        }
        
        // 00 -> 01
        // 01 -> 00
        public boolean equals(Object o){
            Point p = (Point) o;
            if (this.prevX == p.prevX && this.prevY == p.prevY && this.curX == p.curX && this.curY == p.curY){
                return true;
            }
            if (this.prevX == p.curX && this.prevY == p.curY && this.curX == p.prevX && this.curY == p.prevY){
                return true;
            }
            
            return false;
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        Set<Point> set = new HashSet<>();
        
        int x = 0, y = 0;
        
        for (char ch : dirs.toCharArray()){
            if (ch == 'U' && y < 5){
                set.add(new Point(x, y, x, y+1));
                y += 1;
            }
            if (ch == 'D' && -5 < y){
                set.add(new Point(x, y, x, y-1));
                y -= 1;
            }
            if (ch == 'R' && x < 5){
                set.add(new Point(x, y, x+1, y));
                x += 1;
            }
            if (ch == 'L' && -5 < x){
                set.add(new Point(x, y, x-1, y));
                x -= 1;
            }
        }
        
        return set.size();
    }
}