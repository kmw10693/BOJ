import sys
input = sys.stdin.readline

n = int(input())
arr = [0] * 100

arr[1] = 0
arr[2] = 1
arr[3] = 1
for i in range(4, 95):
    arr[i] = arr[i-1] + arr[i-2]

print(arr[n+1])