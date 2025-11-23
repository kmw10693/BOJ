import java.util.*;

class Solution {
    static int[][] destroys;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(String[] storage, String[] requests) {
        String s1 = storage[0];
        destroys = new int[storage.length][s1.length()];
        for(int i=0; i<storage.length; i++) {
            for(int j=0; j<s1.length(); j++) {
                if(i == 0 || i == storage.length-1 || j == 0 || j == s1.length()-1) {
                    destroys[i][j] = 1;
                }
            }
        }
        
        for(String request: requests) {
            int check = request.length() == 1 ? 1 : 2;
            for(int i=0; i<request.length(); i++) {
                if(check == 1) erase(storage, request.charAt(0));
                else eraseAll(storage, request.charAt(0));
            }
            destroyCheck(storage.length, storage[0].length(), storage);
        }
        
        int ans = 0;
        for(int i=0; i<storage.length; i++){
            for(int j=0; j<s1.length(); j++) {
                if(storage[i].charAt(j) != ' ') ans++;
                System.out.print(storage[i].charAt(j));
            }
            System.out.println();
        }
        
        for(int i=0; i<storage.length; i++) {
            for(int j=0; j<s1.length(); j++) {
                System.out.print(destroys[i][j]);
            }
            System.out.println();
        }
        
        return ans;
    }
    
    public void eraseAll(String[] storage, char s) {
        String row = storage[0];
        for(int i=0; i<storage.length; i++) {
            String temp = "";
            for(int j=0; j<row.length(); j++) {
                if(storage[i].charAt(j) == s) temp += ' ';
                else temp += storage[i].charAt(j);
            }
            storage[i] = temp;
        }
    }
    public void erase(String[] storage, char s) {
        String row = storage[0];
        for(int i=0; i<storage.length; i++) {
            String temp = "";
            for(int j=0; j<row.length(); j++) {
                if(destroys[i][j] == 1 && storage[i].charAt(j) == s) {
                    temp += ' ';
                }
                else temp += storage[i].charAt(j);
            }
            storage[i] = temp;
        }
    }
    
    public void destroyCheck(int row, int col, String[] storage) {
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(destroys[i][j] == 1 && storage[i].charAt(j) == ' ') {
                    dfs(i,j, row, col, storage);
                }
            }
        }
    }
    public void dfs(int x, int y, int row, int col, String[] storage) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        
        while(!q.isEmpty()) {
            Node n = q.poll();
            int curX = n.x;
            int curY = n.y;
            
            
            for(int i=0; i<4; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];
                
                if(nxtX < 0 || nxtX >= row || nxtY <0 || nxtY >= col) continue;
                if(destroys[nxtX][nxtY] == 0 && storage[nxtX].charAt(nxtY) == ' ') {
                    q.add(new Node(nxtX, nxtY));
                    destroys[nxtX][nxtY] = 1;
                }
                if(destroys[nxtX][nxtY] == 0) {
                    destroys[nxtX][nxtY] = 1;
                }
            }
        }
    }
   
    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}