def solution(n):
    a = []
    for i in range(1, int(n**(1/2)) + 1):
        print(i)
        if n % i == 0:
            a.append(i)
            if(i**2 != n):
                a.append(n//i)
    return sum(a)