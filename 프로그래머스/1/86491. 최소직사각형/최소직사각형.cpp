#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int maxW = -1;
int maxV = -1;

int solution(vector<vector<int>> sizes) {
    for(int i=0; i<sizes.size(); i++) {
        if(sizes[i][0] > sizes[i][1]) {
            maxW = max(maxW, sizes[i][0]);
            maxV = max(maxV, sizes[i][1]);
        } 
        else {
            maxW = max(maxW, sizes[i][1]);
            maxV = max(maxV, sizes[i][0]);
        }
    }
    return maxW * maxV;
}