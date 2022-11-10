from collections import deque
def solution(rectangles, cx, cy, ix, iy):
    cx *= 2
    cy *= 2
    ix *= 2
    iy *= 2
    def prt(arr):
        for i in arr:
            print(i)
        print()

    def bfs1(i, j):  # 테두리 만드는 BFS
        q = deque([])
        q.append([i, j])
        while (q):
            y, x = q.popleft()
            for dx, dy in (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1):
                # for dy, dx in (-1, 0), (0, 1), (1, 0), (0, -1):
                ny = y + dy
                nx = x + dx
                if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[ny][nx]:
                    continue
                if arr[ny][nx] == 0:
                    q.append([ny, nx])
                    visited[ny][nx] = 1
                if arr[ny][nx] == 1:
                    arr[ny][nx] = 2
                    visited[ny][nx] = 1

    N = 51 * 2 + 1
    arr = [[0] * (N) for _ in range(N)]
    visited = [[0] * (N) for _ in range(N)]

    # 맵 초기화
    for rectangle in rectangles:
        x1, y1, x2, y2 = rectangle
        for i in range(y1 * 2, (y2) * 2 + 1):  #
            for j in range(x1 * 2, (x2) * 2 + 1):  #
                arr[i][j] = 1

    #prt(arr)

    # flood fill 먼저 테두리를 2로 만들기
    for y in range(N):
        for x in range(N):
            if visited[y][x] == 1: continue
            if arr[y][x] != 0: continue
            visited[y][x] = 1
            bfs1(y, x)

    #prt(arr)

    visited = [[0] * N for _ in range(N)]

    def bfs2():  # 모서리만 따라가는 BFS
        q = deque([])
        q.append([cy, cx])
        visited[cy][cx] = 1
        while (q):
            y, x = q.popleft()
            if y == iy and x == ix:
                break
            for dy, dx in (-1, 0), (0, 1), (1, 0), (0, -1):
                ny = y + dy
                nx = x + dx
                if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[ny][nx] > 0:
                    continue
                if arr[ny][nx] == 2:
                    q.append([ny, nx])
                    visited[ny][nx] = visited[y][x] + 1

    bfs2()

    return((visited[iy][ix]-1)//2)
