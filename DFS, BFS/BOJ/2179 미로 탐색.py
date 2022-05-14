import sys
from collections import deque
def BFS(i, j):
    q = deque([])
    visited = [[0] * m for i in range(n)]
    visited[i][j] = 1
    q.append([i, j])
    while q:
        x, y = q.popleft()
        for dx, dy in (0, 1), (1, 0), (0, -1), (-1, 0):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if visited[nx][ny] or not arr[nx][ny]:
                continue
            q.append([nx, ny])
            visited[nx][ny] = visited[x][y] + 1

    return visited[n-1][m-1]

if __name__=="__main__":
    input = sys.stdin.readline
    n, m = map(int, input().split())
    arr = []

    for i in range(n):
        data = list(input().strip())
        temp = []
        for j in data:
            temp.append(int(j))
        arr.append(temp)

    answer = BFS(0, 0)
    print(answer)