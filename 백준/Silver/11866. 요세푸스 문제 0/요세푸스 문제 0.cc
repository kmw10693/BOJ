#include <bits/stdc++.h>

using namespace std;

int main(){
    int n,k;
    cin >> n >> k;
    
    queue<int> q;
    
    for(int i=1; i<=n; i++) {
        q.push(i);
    }
    
    vector<int> v;
    while(!q.empty()) {
        for(int i=0; i<k; i++) {
            if(i == k-1) {
                if(!q.empty()) {
                    v.push_back(q.front());
                    q.pop();
                }
            }
            else {
                if(!q.empty()) {
                    q.push(q.front());
                    q.pop();
                }
            }
        }
    }
    
    cout << '<';
    for(int i=0; i<v.size(); i++) {
        if(i == v.size()-1) {
            cout << v[i] << '>';
        }
        else cout << v[i] << ", ";
    }
    
}