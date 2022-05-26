from collections import deque


def solution(places):
    answer = []

    def sol(c, i, j, place):
        q = deque([])
        q.append([i, j, c])
        visited = [[0] * 5 for i in range(5)]
        visited[i][j] = 1
        while q:
            x, y, cnt = q.popleft()
            if cnt < 0:
                break
            for dx, dy in (0, 1), (1, 0), (-1, 0), (0, -1):
                nx, ny = x + dx, y + dy
                if nx < 0 or nx >= 5 or ny < 0 or ny >= 5 or visited[nx][ny]:
                    continue
                if place[nx][ny] == "P":
                    return 0
                elif place[nx][ny] == "X":
                    continue
                else:
                    q.append([nx, ny, cnt - 1])
                    visited[nx][ny] = 1
        return 1

    def bfs(place):
        for i in range(5):
            for j in range(5):
                if place[i][j] == "P":
                    if not sol(1, i, j, place):
                        return 0
        return 1

    for place in places:
        answer.append(bfs(place))

    return answer