#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> v;

void hanoi(int st, int end, int n) {
    if(n == 1) {
        vector<int> tmp;
        tmp.push_back(st);
        tmp.push_back(end);
        v.push_back(tmp);
        return;
    }
    hanoi(st, 6-st-end, n-1);
    vector<int> tmp;
    tmp.push_back(st);
    tmp.push_back(end);
    v.push_back(tmp);
    hanoi(6-st-end, end, n-1);
}

vector<vector<int>> solution(int n) {
    hanoi(1, 3, n);
    for(int i=0; i<v.size(); i++) {
        cout << v[i][0] << v[i][1];
    }
    return v;
}