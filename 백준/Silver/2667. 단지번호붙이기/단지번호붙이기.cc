#include <bits/stdc++.h>

using namespace std;

#define X first

#define Y second

string arr[40];

bool vis[40][40];

int dx[4] = {1,0,-1,0};

int dy[4] = {0,1,0,-1};

int main() {

    ios::sync_with_stdio(0);

    cin.tie(0);

    

    int N;

    cin >> N;

    for(int i=0; i<N; i++){

        cin >> arr[i];

    }

    

    vector <int> v;

    int tmp = 0;

    for(int i=0; i<N; i++){

        for(int j=0; j<N; j++){

            queue<pair<int,int>> q;

            if(arr[i][j] == '1' && vis[i][j] == 0){

                q.push({i,j});

                vis[i][j] = 1;

                tmp++;

            }

            while(!q.empty()){

                auto t = q.front(); q.pop();

                for(int i=0; i<4; i++){

                    int x = t.X + dx[i];

                    int y = t.Y + dy[i];

                    if(x<0 || x>=N || y<0 || y>= N) continue;

                    if(arr[x][y] != '1' || vis[x][y] == 1) continue;

                    vis[x][y] = 1;

                    tmp++;

                    q.push({x,y});

                }

            }

            if(tmp > 0) v.push_back(tmp);

            tmp = 0;

        }

    }

    sort(v.begin(), v.end());

    cout << v.size() << '\n';

    for(int i=0; i<v.size(); i++){

      cout << v[i] << '\n';

    }

}