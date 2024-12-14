import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [0] * n
for i in range(m):
    a, b, k = map(int, input().split())
    for i in range(a-1, b):
        arr[i] = k

for i in arr:
    print(i, end = ' ')