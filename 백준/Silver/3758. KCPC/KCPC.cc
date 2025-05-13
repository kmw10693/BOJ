#include <bits/stdc++.h>
using namespace std;

int T;
int n, k, t, m;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> T;
    while(T--) {
        cin >> n >> k >> t >> m;
        // 팀 번호, 문제 번호
        int board[105][105] = {0};
        
        // 제출 횟수
        int cnt[105] = {0};
        
        // 마지막 제출 시간
        int final[105] = {0};
        
        for(int l=0; l<m; l++) {
            int i,j,s;
            cin >> i >> j >> s;
            // 갱신
            board[i][j] = max(board[i][j], s);
            // 제출 횟수 1 증가
            cnt[i]++;
            // 마지막 제출 시간
            final[i] = l;
        }
        // 점수, 풀이 제출 횟수, 제출 시간, 인덱스
        vector<pair<pair<int,int>, pair<int,int>>> v;
        for(int i=1; i<=n; i++) {
            int sum = 0;
            for(int j=1; j<=k; j++) {
                sum += board[i][j];
            }
            v.push_back({{sum, -cnt[i]}, {-final[i], i}});
        }
        sort(v.begin(), v.end());
        for(int i=0; i<v.size(); i++) {
            if(v[i].second.second == t)  {
                cout << v.size() - i << "\n";
            }
        }
    }
}