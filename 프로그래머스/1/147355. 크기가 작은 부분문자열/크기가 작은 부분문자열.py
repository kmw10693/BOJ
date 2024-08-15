def solution(t, p):
    length = len(p)
    
    i = 0
    answer = []
    while(True):
        if(i == len(t) - (length -1)): break
        ta = ""
        for _ in range(i, i+length):
            ta += t[_]
        answer.append(ta)
        i +=1
    
    result = 0
    for asd in answer:
        if int(asd) <= int(p): result += 1
    return result
    