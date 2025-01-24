#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int brown, int yellow) {
    int square = brown + yellow;
    vector<int> v;
    
    for(int height=3; height<=sqrt(square); height++){
        if(square % height == 0) {
            int width = square / height;
            
            if((height-2) * (width-2) == yellow) {
                v.push_back(width);
                v.push_back(height);
                break;
            }
        }
    }
    return v;
}