from collections import deque
def solution(maps):
    n = len(maps)
    m = len(maps[0])
    visited = [[0] * m for _ in range(n)]
    visited[n-1][m-1] = -1
    def bfs():
        q = deque([])
        q.append([0, 0])
        visited[0][0] = 1

        while q:
            r, c = q.popleft()
            cnt = visited[r][c]
            for dr, dc in (-1, 0), (0, 1), (1, 0), (0, -1):
                nr = r + dr
                nc = c + dc
                if nr < 0 or nr >= n or nc < 0 or nc >= m: continue
                if maps[nr][nc] == 0: continue
                if visited[nr][nc] > 0: continue
                q.append([nr, nc])
                visited[nr][nc] = cnt + 1
        return
    bfs()
    return visited[n-1][m-1]