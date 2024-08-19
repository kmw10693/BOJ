def solution(participant, completion):
    dict1 = {}
    for p in participant:
        if(p in dict1): dict1[p] -= 1
        else: dict1[p] = 0
    for c in completion:
        dict1[c] += 1
    answer = ""
    for key, value in dict1.items():
        if value <= 0:
            answer = key
    return answer