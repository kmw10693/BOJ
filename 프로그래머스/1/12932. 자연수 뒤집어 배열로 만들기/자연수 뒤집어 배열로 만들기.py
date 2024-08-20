def solution(n):
    s = str(n)
    a = []
    for i in range(len(s)-1, -1, -1):
        a.append(int(s[i]))
        
    return a
        