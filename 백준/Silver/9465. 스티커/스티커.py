import sys
input = sys.stdin.readline

t = int(input())
arr = [[0 for _ in range(100005)] for _ in range(2)]

for i in range(t):
    n = int(input())
    for i in range(2):
        arr[i] = list(map(int, input().split()))

    for i in range(n):
        if i > 1:
            arr[0][i] += max(max(arr[0][i-2], arr[1][i-2]), arr[1][i-1]) 
            arr[1][i] += max(max(arr[0][i-2], arr[1][i-2]) ,arr[0][i-1])
        
        if i == 1:
            arr[0][i] += arr[1][i-1]
            arr[1][i] += arr[0][i-1]

    print(max(arr[0][n-1], arr[1][n-1]))