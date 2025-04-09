#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int a,b,c;
    cin >> a >> b >> c;
    set<int> correct, wrong;
    vector<tuple<int,int,int>> v;
    
    int n;
    cin >> n;
    
    for(int t=0; t<n; t++) {
        int i,j,k,r;
        cin >> i >> j >> k >> r;
        if(r == 1) {
            correct.insert(i);
            correct.insert(j);
            correct.insert(k);
        }
        v.push_back({i,j,k});
    }
    
    bool updated = true;
    while(updated){
        updated = false;
        
        for(auto &[i, j, k]: v) {
            int cnt = 0;
            if(correct.count(i)) cnt++;
            if(correct.count(j)) cnt++;
            if(correct.count(k)) cnt++;
            if(cnt >= 2) {
                if(!correct.count(i) && !wrong.count(i)) {
                    wrong.insert(i);
                    updated = true;
                }
                if(!correct.count(j) && !wrong.count(j)) {
                    wrong.insert(j);
                    updated = true;
                }
                if(!correct.count(k) && !wrong.count(k)) {
                    wrong.insert(k);
                    updated = true;
                }
            }
        }
    }
    
    for(int i=1; i<=a+b+c; i++) {
        int ans = -1;
        if(correct.count(i)) ans = 1;
        else if(wrong.count(i)) ans = 0;
        else if(!correct.count(i) && !wrong.count(i)) ans = 2;
        cout << ans << '\n';
    } 
}