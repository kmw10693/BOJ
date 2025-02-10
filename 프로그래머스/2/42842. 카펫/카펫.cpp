#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<int> solution(int brown, int yellow) {
    int extent = brown + yellow;
    int height = 3;
    vector<int> answer;
    for(int i=height; i<extent; i++) { 
        int width = extent / i;
        
        if(extent % width == 0) {
            int yellowExtent = (i-2) * (width-2);
            if(yellowExtent == yellow) {
                answer.push_back(width);
                answer.push_back(i);
                break;
            }
        }
    }
    return answer;
}