#include <bits/stdc++.h>
using namespace std;

int n;
int x[1005];

vector <int> v;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    for(int i=0; i<n; i++){
        cin >> x[i];
    }
    sort(x, x+n);
    
    for(int i=0; i<n; i++){
        for(int j=i; j<n; j++){
            v.push_back(x[i]+x[j]);
        }
    }
    
    sort(v.begin(), v.end());
    
    for(int i=n-1; i>=0; i--) {
        for(int j=0; j<i; j++) {
            if(binary_search(v.begin(), v.end(), x[i]-x[j])) {
                cout << x[i];
                return 0;
            }
        }
    }
}