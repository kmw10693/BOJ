#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

map<string, int> m;
int vis[100];

void dfs(string s, int len, string c, char prev) {
    if(s.length() == len) {
        m[s]++;
        return;
    }
    
    for(int i=0; i<c.size(); i++) {
        if(!vis[i] && prev <= c[i]) {
            vis[i] =1;
            dfs(s+c[i], len, c, c[i]);
            vis[i] =0;
        }
    }
}
vector<string> solution(vector<string> orders, vector<int> course) {
    vector<string> ans;
    sort(orders.begin(), orders.end());
    
    for(auto C: course) {
        for(auto O: orders) {
            if(O.size() < C) continue;
            dfs("", C, O, 'A');
        }
        int maxV = -1;
        for(auto M : m) {
            cout << M.first << '\n';
            if(M.second > maxV) maxV = M.second;
        }
        for(auto M : m) {
            if(M.second < 2) continue;
            if(M.second == maxV) ans.push_back(M.first);
        }
        m.clear();
    }
    sort(ans.begin(), ans.end());
    return ans;
}