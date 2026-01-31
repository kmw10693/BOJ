import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        List<Node> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            int level = (i-1) / w;
            int index;
            if(level % 2 == 0) {
                index = (i-1) % w;
            } else {
                index = (w-1) - ((i-1) % w);
            }
            list.add(new Node(index, level));
        }
        // 타겟의 인덱스, 레벨 구하기
        Node target = list.get(num-1);
        int ans = 0;
        for(int i=0; i<n; i++) {
            Node cur = list.get(i);
            if(cur.level >= target.level && cur.index == target.index) {
                ans++;
            }
        }
        return ans;
    }
    class Node {
        int index, level;
        Node(int index, int level) {
            this.index = index;
            this.level = level;
        }
    }
}