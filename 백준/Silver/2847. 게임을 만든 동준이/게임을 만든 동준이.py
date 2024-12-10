import sys
input = sys.stdin.readline

n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))

count = 0
for i in range(n):
    for j in range(n-1):
        if arr[j] >= arr[j+1]:
            tmp = (arr[j] - arr[j+1] + 1)
            arr[j] -= tmp
            count += tmp
print(count)