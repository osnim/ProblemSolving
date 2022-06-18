from collections import deque
def BFS(arr, i, j, h, visited):
    q = deque([])
    q.append([i, j])
    while q:
        x, y = q.popleft()
        for dx, dy in (0, 1), (1, 0), (0, -1), (-1, 0):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= n or visited[nx][ny]:
                continue
            if arr[nx][ny] <= h:
                visited[nx][ny] = 1
                arr[nx][ny] = 0
                continue
            q.append([nx, ny])
            visited[nx][ny] = 1
    return 1

n = int(input())
arr = []
MAX = 0
for i in range(n):
    arr.append(list(map(int, input().split())))
    MAX = max(arr[i])

ans = 0
for h in range(MAX):
    q = deque([])
    for i in range(n):
        for j in range(n):
            if arr[i][j] <= h:
                arr[i][j] = 0
            else:
                q.append([i, j])

    visited = [[0] * n for _ in range(n)]
    temp = 0
    while q:
        x, y = q.popleft()
        if visited[x][y]:
            continue
        visited[x][y] = 1
        temp += BFS(arr, x, y, h, visited)
    ans = max(ans, temp)
print(ans)
