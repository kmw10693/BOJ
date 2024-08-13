def solution(cards1, cards2, goal):
    
    card1_idx = 0
    card2_idx = 0
    answer = 'Yes'
    

    for words in goal:
        check = False

        if card1_idx < len(cards1) and cards1[card1_idx] == words: 
            card1_idx += 1
            check = True
        if card2_idx < len(cards2) and cards2[card2_idx] == words: 
            card2_idx += 1
            check = True
        
        if check == False:
            answer = 'No'
            break
    
    return answer