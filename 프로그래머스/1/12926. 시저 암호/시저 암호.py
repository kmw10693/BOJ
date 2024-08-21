def solution(s, n):
    st = ""
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    alphabetU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    
    for i in range(0, len(s)):
        t = 0 
        for j in range(0, len(alphabet)):
            if s[i].isupper():
                if s[i] == alphabetU[j]:
                    st += alphabetU[(j+n)%26]
                    t = 1
            elif s[i].islower():
                if s[i] == alphabet[j]:
                    st += alphabet[(j+n)%26]
                    t = 1
        if t == 0:
            st += " "
    return st