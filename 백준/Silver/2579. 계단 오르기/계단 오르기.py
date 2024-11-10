import sys

arr = [[0] * 303 for _ in range(303)]

main = [0] * 303
n = int(input())
for i in range(1, n + 1):
    k = int(input())
    main[i] = k

arr[1][1] = main[1]
arr[1][2] = 0
arr[2][1] = main[2]
arr[2][2] = main[1] + main[2]

for i in range(3, n + 1):
    arr[i][1] = max(arr[i-2][2], arr[i-2][1]) + main[i]
    arr[i][2] = arr[i-1][1] + main[i]

print(max(arr[n][1], arr[n][2]))