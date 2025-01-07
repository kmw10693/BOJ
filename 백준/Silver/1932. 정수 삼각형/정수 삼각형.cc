#include <bits/stdc++.h>
using namespace std;

int arr[5000][5000];
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    
    cin >> n;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++) cin >> arr[i][j];
    }
    
    if(n == 1) {
        cout << arr[n][1];
        return 0;
    }
    
    for(int i=1; i<=n; i++){
        for(int j=1; j<=i; j++){
            if(j > 1 && j < i) {
                arr[i][j] += max(arr[i-1][j-1], arr[i-1][j]);
            }
            else if(j == 1) arr[i][j] += arr[i-1][j];
            
            else arr[i][j] += arr[i-1][j-1];
        }
    }
    
    cout << *max_element(&arr[n][1], &arr[n][1] + n);

}