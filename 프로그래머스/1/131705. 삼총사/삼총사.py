from itertools import combinations, permutations
def solution(number):
    combi = list(combinations(number, 3))
    answer = 0
    for com in combi:
        sum = 0
        for j in com:
            sum += j
        if sum == 0:
            answer += 1
    return answer