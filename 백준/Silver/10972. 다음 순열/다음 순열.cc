#include <bits/stdc++.h>
using namespace std;

int arr[10005];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    cin >> n;
        
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    
    if(next_permutation(arr, arr+n)) {
        for(int i=0; i<n; i++) {
            cout << arr[i] << ' ';
        }
    }
    else {
        cout << -1;
    }
}