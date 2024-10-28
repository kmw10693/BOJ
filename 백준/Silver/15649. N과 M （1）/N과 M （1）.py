import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = [[' '] for _ in range(10)]
isused = [False for _ in range(10)]

def func(k):
    if k == m:
        for i in range(m):
            print(arr[i], end=' ')
        
        print()
        return;
    else:
        for i in range(1, n+1):
            if isused[i] is False:
                arr[k] = i
                isused[i] = True
                func(k+1)
                isused[i] = False


func(0)
                