#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(int N, int number) {
    if(N == number) return 1;
    
    int answer = 0;
    
    vector<unordered_set<int>> s(10);
    
    int start = 0;
    for(int i=1; i<=8; i++)  {
        
        start = start * 10 + N;
        s[i].insert(start);
        
        for(int j=1; j<=i; j++) {
            for(int k=1; k<=i; k++) {
                if(j+k != i) continue;
                
                for(auto a:s[j]) {
                    for(auto b:s[k]) {
                        s[i].insert(a+b);
                        if(a-b>0) s[i].insert(a-b);
                        s[i].insert(a*b);
                        if(a/b > 0) s[i].insert(a/b);
                    }
                }
            }
        }
        if(s[i].find(number) != s[i].end()) return i;
    }
    return -1;
}