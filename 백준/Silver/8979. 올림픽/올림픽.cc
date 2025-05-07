#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>

using namespace std;

bool compare(const tuple<int, int, int, int>& t1, const tuple<int, int, int, int>& t2) {
    // 금, 은, 동메달 순으로 내림차순 비교
    if (get<1>(t1) != get<1>(t2)) {
        return get<1>(t1) > get<1>(t2);  // 금메달 우선
    }
    if (get<2>(t1) != get<2>(t2)) {
        return get<2>(t1) > get<2>(t2);  // 은메달 우선
    }
    return get<3>(t1) > get<3>(t2);  // 동메달 우선
}

int main() {
    int N, K;
    cin >> N >> K;
    
    vector<tuple<int, int, int, int>> countries;
    
    // 국가 정보 입력 받기
    for (int i = 0; i < N; i++) {
        int country, gold, silver, bronze;
        cin >> country >> gold >> silver >> bronze;
        countries.push_back(make_tuple(country, gold, silver, bronze));
    }
    
    // 국가들을 금, 은, 동메달 순으로 정렬
    sort(countries.begin(), countries.end(), compare);
    
    // K 국가의 순위 찾기
    int rank = 1;  // 첫 번째 국가부터 시작
    for (int i = 0; i < N; i++) {
        // 같은 성적을 가진 국가들이 있으면 공동 순위
        if (i > 0 && get<1>(countries[i]) == get<1>(countries[i - 1]) &&
            get<2>(countries[i]) == get<2>(countries[i - 1]) &&
            get<3>(countries[i]) == get<3>(countries[i - 1])) {
            // 동일한 순위를 가진 국가들은 동일 등수
            continue;
        }
        if (get<0>(countries[i]) == K) {
            cout << rank << endl;
            return 0;
        }
        rank++;
    }
    
    return 0;
}
