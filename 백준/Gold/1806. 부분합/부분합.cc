#include <bits/stdc++.h>
using namespace std;

// 투포인터 알고리즘 O(N)
int arr[100005];

int mx = 0x7fffffff;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N,S;
    cin >> N >> S;
    
    for(int i=0; i<N; i++) {
        int t; cin >> t;
        arr[i] = t;
    }
    
    int st = 0;
    int en = 0;
    int tot = arr[0];
    for(int i=0; i<N; i++) {
        st = i;
        while(en < N && tot < S) {
            en++;
            if(en != N) tot += arr[en];
        }
        if(en == N) break;
        if(mx > en-st+1 && tot >= S) mx = en-st+1;
        tot -= arr[st];
    }
    if(mx == 0x7fffffff) {
        cout << 0;
        return 0;
    }
    cout << mx;
}