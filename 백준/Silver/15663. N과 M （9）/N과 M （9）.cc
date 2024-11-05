#include <bits/stdc++.h>

using namespace std;

int n,m;

int arr[20];

int arr2[20];

bool vis[20];

void cur(int t){

    if(t == m){

        for(int i=0; i<m; i++){

            cout << arr2[i] << ' ';

        }

        cout << '\n';

        return;

    }

    int tmp = 0;

    for(int i = 0; i<n; i++){

        if(!vis[i] && tmp != arr[i]){

           vis[i] = 1;

           arr2[t] = arr[i];

           tmp = arr[i];

           cur(t+1);

           vis[i] = 0;

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