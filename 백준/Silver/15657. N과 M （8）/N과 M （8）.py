n, m = map(int, input().split())
listt = list(map(int, input().split()))
listt.sort()

list1 = [False] * 10
list2 = [0] * 10

def recur(k):
    if k == m:
        for i in range(m): print(list2[i], end=' ')
        print()
    else:
        for i in range(n):
            if list2[k-1] <= listt[i]:
                list2[k] = listt[i]
                recur(k+1)

recur(0)