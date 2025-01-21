#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

map<string, int> m1;
map<string, map<int, int>> m2; // string, 0, 500 

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> v;
    for(int i=0; i<genres.size(); i++) {
        m1[genres[i]] += plays[i];
        m2[genres[i]][i] = plays[i];
    }
    
    while(m1.size() > 0) {
        string genre = "";
        int max = 0;
        
        for(auto mu: m1) {
            if(max < mu.second) {
                max = mu.second;
                genre = mu.first;
            }
        }
        
        for(int i=0; i<2; i++) {
            int l = 0, val = -1;
            for(auto mu: m2[genre]) {
                if(l < mu.second) {
                    l = mu.second;
                    val = mu.first;
                }
            }
            
            if(val == -1) break;
            v.push_back(val);
            m2[genre].erase(val);
        }
        m1.erase(genre);
    }
    return v;
}