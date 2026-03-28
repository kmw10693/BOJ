import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] map = new String[N];

        for(int i=0; i<N; i++) {
            map[i] = br.readLine();
        }

        int totalcnt = 0;
        List<Integer> ansList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
              if(map[i].charAt(j) == '1') {
                  totalcnt++;
                  int count = 1;
                  StringBuilder sb = new StringBuilder(map[i]);
                  sb.setCharAt(j, '-');
                  map[i] = sb.toString();
                  Queue<int[]> q = new ArrayDeque<>();
                  q.add(new int[]{i, j});

                  while (!q.isEmpty()) {
                      int[] cur = q.poll();
                      int curX = cur[0];
                      int curY = cur[1];

                      for(int k=0; k<4; k++) {
                          int nxtX = curX + dx[k];
                          int nxtY = curY + dy[k];

                          if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) continue;
                          if(map[nxtX].charAt(nxtY) != '1') continue;

                          q.add(new int[]{nxtX, nxtY});
                          count++;
                          sb = new StringBuilder(map[nxtX]);
                          sb.setCharAt(nxtY, '-');
                          map[nxtX] = sb.toString();
                      }
                  }
                  ansList.add(count);
              }
            }
        }
        System.out.println(totalcnt);
        ansList.sort((a,b) -> a - b);
        for(int eachans : ansList) {
            System.out.println(eachans);
        }
    }
}