class Solution {
    int n, m;
    int[][] grid;
    int[][] used;          // 칸별 사용된 선로 입출구(비트마스크)
    int[] pieceMask;       // 선로 종류(1~7) -> 방향 비트마스크

    // 방향 인덱스: 0=상(U) 1=하(D) 2=좌(L) 3=우(R)
    final int[] dr  = {-1, 1, 0, 0};
    final int[] dc  = { 0, 0,-1, 1};
    final int[] opp = { 1, 0, 3, 2};   // 반대 방향
    final int[] bit = { 1, 2, 4, 8};   // U,D,L,R 비트

    public int solution(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.used = new int[n][m];

        // 선로 종류별 방향 비트마스크 (U=1, D=2, L=4, R=8)
        //  1,2,3,7 → 예제로 확정.   4,5,6 → 문제 이미지(ex1-1.png) 기준으로 필요시 교체.
        pieceMask = new int[8];
        pieceMask[1] = bit[2] | bit[3]; // {L,R}  ━ 가로 직선
        pieceMask[2] = bit[0] | bit[1]; // {U,D}  ┃ 세로 직선
        pieceMask[3] = 15;              // {U,D,L,R} ╋ (#)
        pieceMask[4] = bit[0] | bit[2]; // {U,L}  (이미지 픽셀로 확정)
        pieceMask[5] = bit[0] | bit[3]; // {U,R}
        pieceMask[6] = bit[1] | bit[3]; // {D,R}
        pieceMask[7] = bit[1] | bit[2]; // {D,L}

        // 시작: (0,0)은 항상 1번, 기차는 오른쪽(R)으로 출발
        int p1 = pieceMask[1];
        if ((p1 & bit[3]) == 0) return 0;          // R 입구 없으면 출발 불가
        for (int d = 0; d < 4; d++) {              // R 외 나머지 입구는 격자 밖으로(시작 터미널)
            if (d == 3 || (p1 & bit[d]) == 0) continue;
            if (in(dr[d], dc[d])) return 0;
        }
        used[0][0] = p1;
        return step(0, 0, 3);                      // (0,0)에서 R 방향으로 나감
    }

    boolean in(int r, int c) { return r >= 0 && r < n && c >= 0 && c < m; }

    // (r,c)에서 mv 방향으로 나간다
    int step(int r, int c, int mv) {
        int nr = r + dr[mv], nc = c + dc[mv];
        if (!in(nr, nc))                           // 격자 밖으로 = 종료
            return (r == n - 1 && c == m - 1 && covered()) ? 1 : 0;
        if (grid[nr][nc] == -1) return 0;          // 장애물로는 못 감
        return enter(nr, nc, opp[mv]);             // 이웃 칸에 opp[mv] 입구로 진입
    }

    // (r,c) 칸에 entry 입구로 들어온다
    int enter(int r, int c, int entry) {
        int cur = used[r][c];
        int t = grid[r][c];

        if (t >= 1 && t <= 7) {                    // 고정 선로
            int ps = pieceMask[t];
            if ((ps & bit[entry]) == 0) return 0;  // 그 입구가 없는 선로면 불가
            if (t != 3) {                          // 2-입구 선로(직선/곡선)
                if (cur != 0) return 0;            // 이미 지났으면 재사용 불가
                int exit = -1;
                for (int d = 0; d < 4; d++)
                    if (d != entry && (ps & bit[d]) != 0) exit = d;
                used[r][c] = ps;
                int res = step(r, c, exit);
                used[r][c] = cur;
                return res;
            } else {                               // 3번 # : 직진(반대편으로)
                int exit = opp[entry];
                if ((cur & bit[entry]) != 0 || (cur & bit[exit]) != 0) return 0;
                used[r][c] = cur | bit[entry] | bit[exit];
                int res = step(r, c, exit);
                used[r][c] = cur;
                return res;
            }
        } else {                                   // 빈칸(0): 선로를 놓는다
            if (cur == 0) {                         // 첫 진입 → 2-입구 선로 배치(출구 3방향 분기)
                int tot = 0;
                for (int exit = 0; exit < 4; exit++) {
                    if (exit == entry) continue;
                    used[r][c] = bit[entry] | bit[exit];
                    tot += step(r, c, exit);
                    used[r][c] = 0;
                }
                return tot;
            } else {                               // 두 번째 진입 → #(교차)로 승격
                if (cur != (bit[0] | bit[1]) && cur != (bit[2] | bit[3])) return 0; // 직선이어야 교차 가능
                int exit = opp[entry];
                if ((cur & bit[entry]) != 0 || (cur & bit[exit]) != 0) return 0;
                used[r][c] = cur | bit[entry] | bit[exit];
                int res = step(r, c, exit);
                used[r][c] = cur;
                return res;
            }
        }
    }

    // 모든 고정 선로를 빠짐없이 지나갔는지 검사
    boolean covered() {
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++) {
                int t = grid[r][c];
                if (t == 0 || t == -1) continue;
                if (t == 3) { if (used[r][c] != 15) return false; }
                else        { if (used[r][c] != pieceMask[t]) return false; }
            }
        return true;
    }
}