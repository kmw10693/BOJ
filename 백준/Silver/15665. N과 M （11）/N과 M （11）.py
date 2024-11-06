n, m = map(int, input().split())
listt = sorted(list(map(int, input().split())))

lista = [''] * 10
vis = [False] * 10

def recur(k):
    if k == m:
        for i in range(m):
            print(lista[i], end=' ')
        print()
    else:
        last = 0
        for i in range(n):
            if vis[i] == False and last != listt[i]:
                lista[k] = listt[i]
                last = lista[k]
                recur(k+1)
recur(0)
            