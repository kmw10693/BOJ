import sys

n,m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

vis = [False] * 10
printArr = [''] * 10

def recur(k):
    if k == m:
        for i in range(k):
            print(printArr[i], end=' ')
        print()
    else:
        for i in range(n):
            if vis[i] == False:
                vis[i] = True
                printArr[k] = arr[i]
                recur(k+1)
                vis[i] = False


recur(0)