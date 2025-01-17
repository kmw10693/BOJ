#include <bits/stdc++.h>

using namespace std;

int n,m;

int r,c,d;

int arr[52][52];

bool vis[52][52];

int nx[4] = {0,-1,0,1};

int ny[4] = {-1,0,1,0};

int ax[4] = {1,0,-1,0};

int ay[4] = {0,-1,0, 1};

int ans2;

// 0 북 1 동 2 남 3 서

void ans(int x, int y, int cur, int t){

    

    cur = cur % 4;

    int tx = x + nx[cur];

    int ty = y + ny[cur];

    if(tx < 0 || tx >= n || ty <0 || ty >= m) return;

    if(t >= 4){

        int ax2 = x + ax[cur];

        int ay2 = y + ay[cur];

        if(arr[ax2][ay2] != 0) return;

        

        ans(ax2, ay2, cur, 0);

        return;

    }

    if(vis[tx][ty] == 0 && arr[tx][ty] == 0){

        ans2++;

        cur += 3;

        vis[tx][ty] = 1;

        ans(tx,ty,cur, 0);

    }

    else{

        cur+=3;

        ans(x,y,cur, ++t);

    }

}

int main() {

    ios::sync_with_stdio(0);

    cin.tie(0);

    

    cin >> n >> m;

    cin >> r >> c >> d;

    

    for(int i=0; i<n; i++){

        for(int j=0; j<m; j++){

            cin >> arr[i][j];

        }

    }

    vis[r][c] = 1;

    ans2 += 1;

    ans(r,c,d,0);

    cout << ans2;

    

    

}