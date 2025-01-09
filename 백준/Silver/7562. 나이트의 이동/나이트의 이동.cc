#include <bits/stdc++.h>

using namespace std;

#define X first

#define Y second

int dx[8] = {-2,-1,1,2,-2,-1,1,2};

int dy[8] = {-1,-2,-2,-1,1,2,2,1};

int arr[302][302];

bool vis[302][302];

int main() {

    ios::sync_with_stdio(0);

    cin.tie(0);

    

    int l;

    cin >> l;

    

    while(l--){

        int ans =0;

        int n;

        cin >> n;

        int x, y;

        cin >> x >> y;

        int x2, y2;

        cin >> x2 >> y2;

        vis[x][y] = 1;

        queue<pair<int,int>> q;

        q.push({x,y});

        while(!q.empty()){

            pair<int,int> q2 = q.front(); q.pop();

            if(arr[x2][y2] > 0) break;

            for(int i=0; i<8; i++){

                int x = q2.X + dx[i];

                int y = q2.Y + dy[i];

                

                if(x<0 || x>=n || y<0 || y>=n) continue;

                if(vis[x][y] > 0) continue;

                

                vis[x][y] =1;

                arr[x][y] = arr[q2.X][q2.Y] + 1;

                q.push({x,y});

            }

        }

        cout << arr[x2][y2] << '\n';

        memset(arr, 0, sizeof(arr));

        memset(vis, 0, sizeof(vis));

    }

}