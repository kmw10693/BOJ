def solution(board, h, w):
    answer = 0
    dh = [0, 1, -1, 0]
    dw = [1, 0, 0, -1]
    color = board[h][w]
    for i in range(len(dh)):
        nx = h + dh[i]
        ny = w + dw[i]
        if 0 <= nx < len(board) and 0 <= ny < len(board):
            if board[nx][ny] == color:
                answer += 1
    return answer