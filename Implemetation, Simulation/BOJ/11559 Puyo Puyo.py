import sys
from collections import deque
input = sys.stdin.readline
matrix = [['.'] * 6 for _ in range(12)]
answer = 0
for i in range(12):
    temp = input()
    for j in range(6):
        if j != '.':
            matrix[i][j] = temp[j]

def bfs(x, y, color):
    visited = [[False] * 6 for _ in range(12)]
    q, result = deque([]), deque([])
    q.append([x, y]), result.append([x, y])
    visited[x][y] = True

    while q:
        r, c = q.popleft()
        for dr, dc in (-1, 0), (0, 1), (1, 0), (0, -1):
            nr, nc = r + dr, c + dc
            if nr < 0 or nr >= 12 or nc < 0 or nc >= 6:
                continue
            if visited[nr][nc]:
                continue
            if matrix[nr][nc] != color:
                continue
            visited[nr][nc] = True
            q.append([nr, nc])
            result.append([nr, nc])

    return result

def boom(result):
    for r, c in result:
        matrix[r][c] = '.'

def Gravity():
    for c in range(6):
        q = deque([])
        for r in range(11, -1, -1):
            if matrix[r][c] != '.':
                q.append(matrix[r][c])

        for r in range(len(q)):
            matrix[11-r][c] = q[r]
        for r in range(12-len(q)):
            matrix[r][c] = '.'
    return

while True:
    flag = False
    #4방 체크
    for i in range(12):
        for j in range(6):
            if matrix[i][j] != '.':
                # 4개 체크
                result = bfs(i, j, matrix[i][j])
                if len(result) >= 4:
                    boom(result)

                    flag = True

    if flag:
        #밑으로 내리기
        Gravity()
        answer += 1
    else:
        print(answer)
        break