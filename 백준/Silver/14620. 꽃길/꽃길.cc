#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second

int N;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int ans = 10000005;
int board[15][15];

void backtrack(vector<pair<int,int>> t) {
    int vis[15][15];
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++) vis[i][j] = 0;
    }
    
    int minValue = 0;
    
    for(int i=0; i<t.size(); i++) {
        int curX = t[i].X;
        int curY = t[i].Y;
        
        if(vis[curX][curY]) return;
        
        minValue += board[curX][curY];
        vis[curX][curY] = 1;
        
        for(int i=0; i<4; i++) {
            int nxtX = curX + dx[i];
            int nxtY = curY + dy[i];
            
            if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) return;
            if(vis[nxtX][nxtY]) return;
            
            minValue += board[nxtX][nxtY];
            vis[nxtX][nxtY] = 1;
        }
    }
    ans = min(ans, minValue);
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N;
    vector<pair<int,int>> v;
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++){
            cin >> board[i][j];
            v.push_back({i,j});
        }
    }

    // backtrack
    vector<int> temp;
    for(int i=0; i<3; i++) {
        temp.push_back(1);
    }
    
    for(int i=0; i<v.size()-3; i++) {
        temp.push_back(0);
    }
    sort(temp.begin(), temp.end());
    
    do {
        vector<pair<int, int>> temp2;
        for(int i=0; i<temp.size(); i++) {
            if(temp[i] == 1) {
               temp2.push_back({v[i].X, v[i].Y});
            }
        }
        backtrack(temp2);
    } while(next_permutation(temp.begin(), temp.end()));
    
    cout << ans;
}