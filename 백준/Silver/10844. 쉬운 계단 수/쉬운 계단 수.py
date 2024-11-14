n = int(input())

arr = [[0]*105 for _ in range(105)]

arr[0][1] = 0
for i in range(1, 10):
    arr[i][1] = 1

arr[0][2] = 1
arr[1][2] = 1
arr[9][2] = 1
for i in range(2, 9):
    arr[i][2] = 2
    

for i in range(3, 101):
    for j in range(0, 10):
        if j == 0:
            arr[j][i] = arr[1][i-1]
        elif j == 9:
            arr[j][i] = arr[8][i-1]
        elif j == 1:
            arr[j][i] = arr[2][i-1] + arr[0][i-1]
        else:
            arr[j][i] = arr[j-1][i-1] + arr[j+1][i-1]

ans = 0
for i in range(10):
    ans += arr[i][n]
    
print(ans%1000000000)