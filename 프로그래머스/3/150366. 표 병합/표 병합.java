import java.util.*;

class Solution {

    static int[] parent;
    static String[] value;

    public String[] solution(String[] commands) {

        // 50 * 50 = 2500
        parent = new int[2501];
        value = new String[2501];

        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
        }

        List<String> answer = new ArrayList<>();

        for (String command : commands) {

            String[] cmd = command.split(" ");

            if (cmd[0].equals("UPDATE")) {

                // UPDATE r c value
                if (cmd.length == 4) {

                    int r = Integer.parseInt(cmd[1]);
                    int c = Integer.parseInt(cmd[2]);
                    String newValue = cmd[3];

                    int idx = getIndex(r, c);
                    int root = find(idx);

                    value[root] = newValue;
                }

                // UPDATE value1 value2
                else {

                    String value1 = cmd[1];
                    String value2 = cmd[2];

                    for (int i = 1; i <= 2500; i++) {

                        // 값은 root에만 저장되어 있음
                        if (value[i] != null && value[i].equals(value1)) {
                            value[i] = value2;
                        }
                    }
                }
            }

            else if (cmd[0].equals("MERGE")) {

                int r1 = Integer.parseInt(cmd[1]);
                int c1 = Integer.parseInt(cmd[2]);
                int r2 = Integer.parseInt(cmd[3]);
                int c2 = Integer.parseInt(cmd[4]);

                int idx1 = getIndex(r1, c1);
                int idx2 = getIndex(r2, c2);

                int root1 = find(idx1);
                int root2 = find(idx2);

                // 이미 같은 그룹
                if (root1 == root2) {
                    continue;
                }

                /*
                 * 문제 조건:
                 *
                 * 둘 다 값이 있으면 (r1, c1)의 값
                 * 하나만 값이 있으면 그 값
                 */

                String mergedValue;

                if (value[root1] != null) {
                    mergedValue = value[root1];
                } else {
                    mergedValue = value[root2];
                }

                // root2 그룹을 root1에 합침
                parent[root2] = root1;

                value[root1] = mergedValue;
                value[root2] = null;
            }

            else if (cmd[0].equals("UNMERGE")) {

                int r = Integer.parseInt(cmd[1]);
                int c = Integer.parseInt(cmd[2]);

                int idx = getIndex(r, c);

                // 현재 그룹 대표
                int root = find(idx);

                // 병합된 셀이 가지고 있던 값
                String savedValue = value[root];

                /*
                 * 매우 중요
                 *
                 * 먼저 root가 같은 셀들을 찾아놓아야 함.
                 *
                 * 루프 도중 parent를 바로 초기화하면
                 * find() 결과가 달라질 수 있음.
                 */
                List<Integer> group = new ArrayList<>();

                for (int i = 1; i <= 2500; i++) {

                    if (find(i) == root) {
                        group.add(i);
                    }
                }

                // 모든 셀을 독립된 셀로 되돌림
                for (int cell : group) {
                    parent[cell] = cell;
                    value[cell] = null;
                }

                // UNMERGE를 요청한 위치에만 기존 값 유지
                value[idx] = savedValue;
            }

            else if (cmd[0].equals("PRINT")) {

                int r = Integer.parseInt(cmd[1]);
                int c = Integer.parseInt(cmd[2]);

                int idx = getIndex(r, c);
                int root = find(idx);

                if (value[root] == null) {
                    answer.add("EMPTY");
                } else {
                    answer.add(value[root]);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    static int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static int getIndex(int r, int c) {
        return (r - 1) * 50 + c;
    }
}