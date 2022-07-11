from collections import deque
M, N = map(int, input().split())
arr = []
tomato = []
for i in range(N):
    data = list(map(int, input().split()))
    arr.append(data)
    for j in range(M):
        if data[j] == 1: # 토마토가 있다면
            tomato.append([i, j]) #토마토의 좌표

def BFS():
    q = deque([])
    visited = [[0]*M for _ in range(N)]
    MAX = 0
    for x, y in tomato: # 토마토 1 좌표를 모두 q에 넣음
        q.append([x, y, 1])
        visited[x][y] = 1
    while q:
        x, y, s = q.popleft() #좌표, 사이즈
        s += 1
        for dx, dy in (1, 0), (-1, 0), (0, 1), (0, -1):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= N or ny < 0 or ny >= M or visited[nx][ny]:
                continue
            if arr[nx][ny] == -1:
                continue
            q.append([nx, ny, s])
            visited[nx][ny] = 1
            arr[nx][ny] = s
            MAX = max(s, MAX)

    return MAX-1

ans = BFS()
for i in range(N):
    if 0 in arr[i]:
        print(-1)
        exit()
if ans == -1:
    print(0)
else:
    print(ans)