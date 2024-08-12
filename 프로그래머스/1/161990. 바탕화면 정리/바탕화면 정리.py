def solution(wallpaper):
    x =[]
    y = []
    for r in range(len(wallpaper)):
        for l in range(len(wallpaper[0])):
            if wallpaper[r][l] == '#':
                x.append(r)
                y.append(l)
    return [min(x), min(y), max(x)+1, max(y) + 1]