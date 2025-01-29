#include <bits/stdc++.h>

using namespace std;

int N;
int A[100005];

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N;
    for(int i=0; i<N; i++) cin >> A[i];
    
    sort(A, A+N);
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        cout << binary_search(A, A+N, n) << '\n';
    }
    
}