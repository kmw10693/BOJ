import java.util.*;
import java.io.*;

class Solution {
    int n;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    boolean same(List<int[]> a, List<int[]> b) {
        if(a.size() != b.size()) return false;
        
        for(int i=0; i<a.size(); i++) {
            if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }

    List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        
        for(int[] p : shape) {
            int r=p[0];
            int c=p[1];
            
            rotated.add(new int[]{c,-r});
        }
        return normalize(rotated);
    }
    
    List<int[]> normalize(List<int[]> shape) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        
        for(int[] p : shape) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }
        
        List<int[]> result = new ArrayList<>();
        
        for(int[] p : shape) {
            result.add(new int[]{p[0] - minR, p[1] - minC});
        }
        
        result.sort((a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        return result;
    }

    List<int[]> bfs(int[][] board, boolean[][] visited, int sr, int sc, int target) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> shape = new ArrayList<>();
        
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int r = cur[0];
            int c = cur[1];
            
            shape.add(new int[]{r,c});
            
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr>=n || nc < 0 || nc >=n) continue;
                if(visited[nr][nc]) continue;
                if(board[nr][nc] != target) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }
        return shape;
    }
    List<List<int[]>> getShapes(int[][] board, int target) {
        boolean[][] visited = new boolean[n][n];
        
        List<List<int[]>> shapes = new ArrayList<>();
        
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(!visited[r][c] && board[r][c] == target) {
                    List<int[]> shape = bfs(board, visited, r, c, target);
                    shapes.add(normalize(shape));
                }
            }
        }
        return shapes;
    }
    
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        
        List<List<int[]>> blanks = getShapes(game_board, 0);
        
        List<List<int[]>> puzzles = getShapes(table, 1);
        boolean[] used = new boolean[puzzles.size()];
        
        int answer = 0;
        
        for(List<int[]> blank : blanks) {
            for(int i=0; i<puzzles.size(); i++) {
                if(used[i]) continue;
                
                List<int[]> puzzle = puzzles.get(i);
                
                if(blank.size() != puzzle.size()) continue;
                List<int[]> current = puzzle;
                
                for(int r=0; r<4; r++) {
                    if(same(blank, current)) {
                        used[i] = true;
                        answer += blank.size();
                        break;
                    }
                    current = rotate(current);
                }
                
                if(used[i]) break;
            }
        }
        return answer;
        
    }
}