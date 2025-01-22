#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

stack<int> s;

vector<int> solution(vector<int> prices) {
    vector<int> v(prices.size());
    
    for(int i=0; i<prices.size(); i++){
        while(!s.empty() && prices[s.top()] > prices[i]) {
            v[s.top()] = i - s.top();
            s.pop();
        }
        s.push(i);
    }
    while(!s.empty()) {
        v[s.top()] = prices.size()-1 - s.top();
        s.pop();
    }
    return v;
}