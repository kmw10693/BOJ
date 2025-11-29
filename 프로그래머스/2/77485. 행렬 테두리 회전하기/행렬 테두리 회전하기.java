import java.util.*;

class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows][columns];
        int start = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++){
                map[i][j] = start++;
            }
        }
        
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            rotate(queries[i]);
            ans[i] = getMin(queries[i]);
        }
        return ans;
    }
    public void rotate(int[] queries) {
        int sr = queries[0] - 1;
        int sc = queries[1] - 1;
        
        int er = queries[2] - 1;
        int ec = queries[3] - 1;
        
        List<Node> arr = new ArrayList<>();
        for(int i=sc; i<=ec; i++) {
            arr.add(new Node(sr, i, map[sr][i]));
        }
        for(int i=sr+1; i<er; i++) {
            arr.add(new Node(i, ec, map[i][ec]));
        }
        for(int i=ec; i>=sc; i--) {
            arr.add(new Node(er, i, map[er][i]));
        }
        for(int i=er-1; i>sr; i--) {
            arr.add(new Node(i, sc, map[i][sc]));
        }
        int lastv = arr.get(arr.size()-1).value;
        
        for(int i=arr.size()-1; i>0; i--) {
            Node cur = arr.get(i);
            Node prev = arr.get(i-1);
            cur.value = prev.value;
        }
        Node first = arr.get(0);
        first.value = lastv;
        
        for(int i=0; i<arr.size(); i++) {
            int x = arr.get(i).x;
            int y = arr.get(i).y;
            int value = arr.get(i).value;
            map[x][y] = value;
        }
    }
    
    public int getMin(int[] queries) {
        List<Integer> temp = new ArrayList<>();
        // 2 2
        int sr = queries[0] - 1;
        int sc = queries[1] - 1;
        
        // 5 4
        int er = queries[2] - 1;
        int ec = queries[3] - 1;
        
        for(int i=sr; i<=er; i++) {
            for(int j=sc; j<=ec; j++) {
                if(i != sr && i != er) {
                    if(j == sc || j == ec) temp.add(map[i][j]);
                }
                else temp.add(map[i][j]);
            }
        }
        int minv = 0x7fffffff;
        System.out.println(temp.size());
        for(int i=0; i<temp.size(); i++) {
            if(temp.get(i) < minv) minv = temp.get(i); 
        }
        return minv;
    }
    class Node {
        int x;
        int y;
        int value;
        Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}