import sys
from collections import deque
input = sys.stdin.readline
T = int(input().strip())

def BFS(i, j, arr, visited):
    q = deque([])
    q.append([i, j])
    visited[i][j] = 1
    while q:
        x, y = q.popleft()
        for dx, dy in (-1, 0), (1, 0), (0, 1), (0, -1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= M or visited[nx][ny]:
                continue
            if arr[nx][ny] == 1:
                q.append([nx, ny])
                visited[nx][ny] = 1
    return 1

for _ in range(T):
    M, N, K = map(int, input().split())
    arr = [[0]*M for _ in range(N)]
    visited = [[0]*M for _ in range(N)]
    cnt = 0
    for _ in range(K):
        j, i = map(int, input().split())
        arr[i][j] = 1

    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1 and not visited[i][j]:
                cnt += BFS(i, j, arr, visited)
    print(cnt)