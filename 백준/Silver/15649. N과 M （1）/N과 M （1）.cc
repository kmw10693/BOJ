#include <bits/stdc++.h>

using namespace std;

int n,m;

int vis[15];
int arr[15];

void func(int k) {
    if(k == m) {
        for(int i=0; i<m; i++){
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return;
    }
    
    for(int i=1; i<=n; i++){
        if(!vis[i]) {
            vis[i] = 1;
            arr[k] = i;
            func(k+1);
            vis[i] = 0;
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n >> m;
    func(0);
}