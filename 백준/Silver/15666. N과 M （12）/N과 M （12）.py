n, m = map(int, input().split())
lista = sorted(list(map(int, input().split())))
listt = [''] * 10

def recur(k):
    if k == m:
        for i in range(m):
            print(listt[i], end =' ')
        print()
        return
        
    else:
        last_num = 0
        for i in range(n):
            if((k == 0 and last_num != lista[i]) or (last_num != lista[i] and listt[k-1] <= lista[i])):
                listt[k] = lista[i]
                last_num = listt[k]
                recur(k+1)

recur(0)