def solution(s, skip, index):
    answer = ''
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    for i in skip:
        alphabet = alphabet.replace(i, '')
        
    for j in s:
        idx = (alphabet.index(j) + index) % len(alphabet)
        answer += alphabet[idx]
    return answer