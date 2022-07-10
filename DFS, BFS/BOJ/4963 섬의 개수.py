from collections import deque

def BFS(i, j):
    q = deque([])
    q.append([i, j])

    while q:
        x, y = q.popleft()
        for dx, dy in (0,1), (0,-1), (1,0), (-1,0), (-1, 1), (-1, -1), (1, -1), (1, 1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= h or ny < 0 or ny >= w or visited[nx][ny]:
                continue
            if not arr[nx][ny]:
                continue
            q.append([nx, ny])
            visited[nx][ny] = 1
    return

while True:
    w, h = map(int, input().split())
    if w+h == 0:
        break
    arr = []
    for i in range(h):
        arr.append(list(map(int, input().split())))
    visited = [[0]*w for _ in range(h)]
    cnt = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j] == 1 and not visited[i][j]:
                visited[i][j] = 1
                BFS(i, j)
                cnt += 1
    print(cnt)