def solution(keymap, targets):
    answer = []
    
    for words in targets:
        tmpAns = 0
        
        for word in words:
            check = False
            maxN = 102
            for keys in keymap:
                for key in keys:
                    if key == word:
                        check = True
                        maxN = min(keys.index(key) + 1, maxN)
                
            if check == False:
                tmpAns = -1
                break
            else:
                tmpAns += maxN
    
        answer.append(tmpAns)
    return answer
