#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

unordered_map<int, int> m;

int solution(vector<int> numbers) {
    for(int i=1; i<=9; i++) {
        m[i] = 1;
    }
    
    for(auto t : numbers) {
        m[t] = 0;
    }
    
    int sum = 0;
    for(auto iter=m.begin(); iter != m.end(); iter++) {
        if(iter->second == 1) sum += iter->first;
    }
    return sum;
}