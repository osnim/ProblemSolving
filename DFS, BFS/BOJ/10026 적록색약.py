import sys
from collections import deque
from collections import defaultdict
def BFS(i, j, visited, dic):
    q = deque([])
    q.append([i, j])
    colors = [0]*3
    if arr[i][j] == "R":
        dic["R"] += 1
    elif arr[i][j] == "G":
        dic["R"] += 1
    else:
        dic["B"] += 1

    while q:
        x, y = q.popleft()
        for dx, dy in (0, 1), (0, -1), (1, 0), (-1, 0):
            nx, ny = x + dx, y + dy
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if visited[nx][ny]:
                continue
            if arr[x][y] == arr[nx][ny]:
                visited[nx][ny] = 1
                q.append([nx, ny])
    return dic


if __name__=="__main__":
    input = sys.stdin.readline
    n = int(input().strip())
    arr = []
    for i in range(n):
        string = list(input().strip())
        temp = []
        for s in string:
            temp.append(s)
        arr.append(temp)
    n = len(arr)
    m = len(arr[0])
    visited = [[0] * m for _ in range(n)]
    colors = defaultdict(list)
    #leak = defaultdict(list)
    colors["R"] = 0
    colors["G"] = 0
    colors["B"] = 0
    normal = 0
    leak = 0
    for i in range(n):
        for j in range(m):
            if visited[i][j]:
                continue
            visited[i][j] = 0
            colors = BFS(i, j, visited, colors)
    normal = sum(colors.values())

    for i in range(n):
        for j in range(m):
            if arr[i][j] == "G":
                arr[i][j] = "R"

    colors["R"] = 0
    colors["G"] = 0
    colors["B"] = 0
    visited = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if visited[i][j]:
                continue
            visited[i][j] = 0
            colors = BFS(i, j, visited, colors)
    leak = sum(colors.values())
    print(normal, leak)

