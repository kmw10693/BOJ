import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        int result = 0;
        Set<Node> s = new HashSet<>();
        System.out.print(s.size());
        
        int curX = 0, curY = 0;
        for(int i=0; i<dirs.length(); i++) {
            int tmpx = curX;
            int tmpy = curY;
            if(dirs.charAt(i) == 'U') {
                curX += dx[0];
                curY += dy[0];
                if(curX < -5 || curX > 5 || curY < -5 || curY > 5) {
                    curX -= dx[0];
                    curY -= dy[0];
                    continue;
                }
            
                s.add(new Node(tmpx, tmpy, curX, curY));
            } else if (dirs.charAt(i) == 'D') {
                curX += dx[1];
                curY += dy[1];
                if(curX < -5 || curX > 5 || curY < -5 || curY > 5) {
                    curX -= dx[1];
                    curY -= dy[1];
                    continue;
                }
                s.add(new Node(tmpx, tmpy, curX, curY));
                
            } else if (dirs.charAt(i) == 'R') {
                curX += dx[2];
                curY += dy[2];
                if(curX < -5 || curX > 5 || curY < -5 || curY > 5) {
                    curX -= dx[2];
                    curY -= dy[2];
                    continue;
                }
                s.add(new Node(tmpx, tmpy, curX, curY));
                
            } else {
                curX += dx[3];
                curY += dy[3];
                if(curX < -5 || curX > 5 || curY < -5 || curY > 5) {
                    curX -= dx[3];
                    curY -= dy[3];
                    continue;
                }
                s.add(new Node(tmpx, tmpy, curX, curY));
                
            }
        }
        return s.size();
    }
    static class Node {
        int curx, cury, nxtx, nxty;
        Node(int curx, int cury, int nxtx, int nxty) {
            if(curx < nxtx || (curx == nxtx && cury <= nxty)) {
                this.curx = curx;
                this.nxtx = nxtx;
                this.cury = cury;
                this.nxty = nxty;
            } else {
                this.curx = nxtx; 
                this.nxtx = curx;
                this.nxty = cury;
                this.cury = nxty;
            }
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Node)) return false;
            Node n = (Node) o;
            if(n.curx == curx && n.cury == cury && n.nxtx == nxtx && n.nxty == nxty) return true;
            if(n.nxtx == curx && n.nxty == cury && n.curx == nxtx && n.cury == nxty) return true;
            return false;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(curx, cury, nxtx, nxty);
        }
    }
}