#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

ll n;
vector<ll> v;

bool check(ll value) {
    for(auto &V : v) {
        if (value < V) return false;
        value -= value % V; 
    }
    return true;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    for(int i=0; i<n; i++) {
        ll a;
        cin >> a;
        v.push_back(a);
    }
    
    ll low = 0, high = 1e16, mid;
    while(low <= high) {
        mid = (low + high) / 2;
        if(check(mid)) {
            high = mid - 1;
        }
        else low = mid + 1;
    }
    cout << low;
}