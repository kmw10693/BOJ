#include <bits/stdc++.h>

using namespace std;

int n,m,h;
int jx, jy;

int board[15][15];
int ans = 0;

vector<tuple<int,int,bool>> mm;

void backtrack(int curX, int curY, int rem, int val) {
    if(abs(jx - curX) + abs(jy - curY) <= rem) {
        ans = max(ans, val);
    } 
    
    if(rem <= 0 || val == mm.size()) return;
    
    for(int i=0; i<mm.size(); i++) {
        int x, y;
        bool vis;
        tie(x, y, vis) = mm[i];
        
        if(!vis && abs(curX - x) + abs(curY - y) <= rem) {
            get<2>(mm[i]) = true;
            backtrack(x, y, rem - (abs(curX - x) + abs(curY - y))+ h, val+1);
            get<2>(mm[i]) = false;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m >> h;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> board[i][j];
            if(board[i][j] == 1) {
                jx = i;
                jy = j;
            }
            if(board[i][j] == 2) mm.push_back({i,j, false});
        }
    }
    backtrack(jx, jy, m, 0);
    cout << ans;
  
}