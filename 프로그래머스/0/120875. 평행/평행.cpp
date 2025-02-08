#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
vector<vector<int>> tmpdots;

double getA(int i1, int i2) {
    return (double)(tmpdots[i1][1] - tmpdots[i2][1]) / (tmpdots[i1][0] - tmpdots[i2][0]);
}

int solution(vector<vector<int>> dots) {
    tmpdots = dots;
    vector <int> v;
    v.push_back(0);
    v.push_back(0);
    v.push_back(1);
    v.push_back(1);
    sort(v.begin(), v.end());
    
    do {
        vector<int> t;
        vector<int> t2;
        for(int i=0; i<v.size(); i++) {
            if(v[i] == 0) t.push_back(i);
            if(v[i] == 1) t2.push_back(i);
        }
        if(getA(t[0], t[1]) == getA(t2[0], t2[1])) return 1;
    } while(next_permutation(v.begin(), v.end()));
    return 0;
}