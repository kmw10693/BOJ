def recur(n, x, y):
    if n == 3:
        for i in range(n):
            for j in range(n):
                if i == 1 and j == 1:
                    listk[x+i] = listk[x+i][:y+j] + ' ' + listk[x+i][y+j+1:]
                else:
                    listk[x+i] = listk[x+i][:y+j] + '*' + listk[x+i][y+j+1:]
        return
    
    k = n // 3
    for i in range(3):
        for j in range(3):
            if i == 1 and j == 1:
                continue  # Skip the center square
            recur(k, x + i * k, y + j * k)
            
N = int(input())
listk = [' ' * N for _ in range(N)] # Create a list of strings
recur(N, 0, 0)

for row in listk:
    print(row)