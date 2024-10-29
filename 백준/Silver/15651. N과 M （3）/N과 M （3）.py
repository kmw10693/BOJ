N, M = map(int, input().split())
list1 = [False] * 10
list2 = [0] * 10

def recur(k):
    
    if k == M:
        for i in range(M):
            print(list2[i], end=' ')
        print()
        return
    for i in range(1, N+1):
        list2[k] = i
        recur(k+1)
recur(0)