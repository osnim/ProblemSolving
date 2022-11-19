from collections import deque

def bfs(sr, sc):
    global arr, N, visited, tr, tc
    q = deque([])
    visited[sr][sc] = -1
    q.append([sr, sc, 0])
    while q:
        r, c, t = q.popleft()
        if r == tr and c == tc:
            return t
        for dr, dc in (-1, 0), (0, 1), (1, 0), (0, -1):
            nr, nc = r+dr, c+dc
            if nr < 0 or nr >= N or nc < 0 or nc >= N:
                continue
            if visited[nr][nc] != 0:
                continue
            if arr[nr][nc] == 1: #장애물
                continue
            if arr[nr][nc] == 2 and t%3 != 2: # 0, 1 안되고 2초 가능, 3, 4 안되고 5초 가능
                q.append([r, c, t + 1])
                continue
            q.append([nr, nc, t+1])
            visited[nr][nc] = t+1

    return -1


T = int(input())
for t in range(1, T + 1):
    global N, arr, visited, tr, tc
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]
    visited = [[0] * N for _ in range(N)]

    sr, sc = map(int, input().split())
    tr, tc = map(int, input().split())

    print(f'#{t} {bfs(sr, sc)}')
