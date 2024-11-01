#include <bits/stdc++.h>

using namespace std;

int n,m;

int arr[10];

int arr2[10];

bool vis[200000];

void cur(int t){

    if(t == m){

        for(int i=0; i<m; i++){

            cout << arr2[i] << ' ';

        }

        cout << '\n';

        return;

    }

    

    for(int i=0; i<n; i++){

        if(!vis[arr[i]]){

            vis[arr[i]] = 1;

            arr2[t] = arr[i];

            cur(t+1);

            vis[arr[i]] = 0;

        }

    }

}

int main() {

    ios::sync_with_stdio(0);

    cin.tie(0);

    

    cin >> n >> m;

    for(int i=0; i<n; i++){

        cin >> arr[i];

    }

    sort(arr, arr+n);

    cur(0);

}