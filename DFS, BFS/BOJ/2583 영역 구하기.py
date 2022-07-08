from collections import deque
import sys
input = sys.stdin.readline
def BFS(i, j):
    q = deque([])
    q.append([i, j])
    S = 1 # 넓이
    while q:
        x, y = q.popleft()
        for dx, dy in (1, 0), (-1, 0), (0, 1), (0, -1):
            nx, ny = x+dx, y+dy
            if nx < 0 or nx >= N or ny < 0 or ny >= M or filled[nx][ny]:
                continue
            q.append([nx, ny])
            S += 1
            filled[nx][ny] = 1

    return S

N, M, K = map(int, input().split())
filled = [[0]*M for _ in range(N)]

for i in range(K):
    y1, x1, y2, x2 = map(int, input().split())
    X1 = N - x2
    X2 = N - x1
    for i in range(X1, X2):
        for j in range(y1, y2):
            filled[i][j] = 1

answer = []
for i in range(N):
    for j in range(M):
        if not filled[i][j]:
            filled[i][j] = 1
            answer.append(BFS(i, j))
answer.sort()
print(len(answer))
print(*answer)