def solution(N, stages):
    result = {}
    result2 = []
    for i in range(1, N+1):
        k = 0
        a = 0
        for _ in stages:
            if _ == i:
                k += 1
                a += 1
            elif _ > i:
                a += 1
        
        if a == 0:
            result[i] = 0
        else:
            result[i] = k/a
    dict1 = sorted(result.items(), key=lambda x : x[1], reverse = True)
    for a,b in dict1:
        result2.append(a)
    
    return result2