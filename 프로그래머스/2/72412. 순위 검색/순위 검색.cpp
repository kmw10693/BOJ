#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

unordered_map<string, vector<int>> m;

void addCase(vector<string> v, int score) {
    for(int i=0; i<16; i++) {
        int num = i;
        string tmp = "";
        for(int j=0; j<4; j++) {
            if(num<=0 || num %2 == 0) tmp += '-';
            else tmp += v[j];
            num /= 2;
        }
        m[tmp].push_back(score);
    }
}

vector<int> solution(vector<string> info, vector<string> query) {
    vector <string> v(5);
    vector <int> ans;
    for(auto i : info) {
        istringstream ss(i);
        ss >> v[0] >> v[1] >> v[2] >> v[3] >> v[4];
        addCase(v, stoi(v[4]));
    }
    
    for(auto iter = m.begin(); iter!=m.end(); iter++) {
        sort(iter->second.begin(), iter->second.end());
    }
    
    for(auto q : query) {
        istringstream ss(q);
        int score;
        ss >> v[0] >> v[4] >> v[1] >> v[4] >> v[2] >> v[4] >> v[3] >> score;
        
        vector<int> v2 = m[v[0]+v[1]+v[2]+v[3]];
        if(v2.empty()) {
            ans.push_back(0);
            continue;
        }
        
        int k = lower_bound(v2.begin(), v2.end(), score) - v2.begin();
        ans.push_back(v2.size() - k);
    }
    return ans;
}