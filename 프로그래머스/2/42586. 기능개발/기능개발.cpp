#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> v;
    
    for(int i=0; i<progresses.size(); i++) {
        int tmp = 100 - progresses[i];
        if(tmp % speeds[i] == 0) tmp /= speeds[i];
        else tmp = (tmp / speeds[i]) + 1;
        v.push_back(tmp);
    }
    
    
    stack<int> s;
    s.push(v[0]);
    
    int tmp = 0;
    vector<int> ans;
    ans.push_back(0);
    
    for(int i=0; i<v.size(); i++) {
        if(s.top() < v[i]) {
            ans.push_back(1);
            tmp++;
            if(!s.empty()) {
                s.pop();
                s.push(v[i]);
            }
        }
        else ans[tmp]++;
    }
    return ans;
}