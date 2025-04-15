#include <bits/stdc++.h>
using namespace std;

map<string, int> m;     // 차량 입차 시간 저장
map<string, int> ans;   // 차량 누적 주차 시간 저장

vector<int> solution(vector<int> fees, vector<string> records) {
    int baseTime = fees[0], baseFee = fees[1];
    int unitTime = fees[2], unitFee = fees[3];
    
    for (string record : records) {
        stringstream ss(record);
        string timeStr, number, inout;
        ss >> timeStr >> number >> inout;
        
        int hour = stoi(timeStr.substr(0, 2));
        int minute = stoi(timeStr.substr(3, 2));
        int totalMinutes = hour * 60 + minute;
        
        if (inout == "IN") {
            m[number] = totalMinutes;
        } else {
            int duration = totalMinutes - m[number];
            ans[number] += duration;
            m.erase(number);
        }
    }
    
    // 아직 출차 안 한 차량 처리 (23:59 기준)
    for (auto& p : m) {
        string number = p.first;
        int inTime = p.second;
        int duration = (23 * 60 + 59) - inTime;
        ans[number] += duration;
    }
    
    // 요금 계산
    vector<pair<string, int>> sortedAns(ans.begin(), ans.end());
    sort(sortedAns.begin(), sortedAns.end());
    
    vector<int> result;
    for (auto& p : sortedAns) {
        int totalTime = p.second;
        int cost = baseFee;
        if (totalTime > baseTime) {
            cost += ((totalTime - baseTime + unitTime - 1) / unitTime) * unitFee;
        }
        result.push_back(cost);
    }
    
    return result;
}
