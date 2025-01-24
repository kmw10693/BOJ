#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

set<int> s;
vector<char> v;

int answer = 0;

void check() {
    for(auto iter = s.begin(); iter != s.end(); iter++) {
        bool tmp = true;
        if(*iter == 0 || *iter == 1) tmp = false;
    
        for(int i=2; i<*iter; i++) {
            if(*iter == 2) {
                break;
            }
            if(*iter % i == 0) {
                tmp = false;
                break;
            }
        }
        if(tmp == true) answer++;
    }
}

int solution(string numbers) {
    for (auto n : numbers) {
        v.push_back(n);
    }
    
    sort(v.begin(), v.end());
    for(int i=1; i<=v.size(); i++) {
        do {
            string tmp = "";
            for(int j=0; j<i; j++) {
                tmp += v[j];
            }
            s.insert(stoi(tmp));
        } while(next_permutation(v.begin(), v.end()));
    }
    check();
    return answer;
}