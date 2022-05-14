def solution(n, computers):
    answer = n
    visited = [0] * n
    Linked = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if computers[i][j] == 0:
                continue
            Linked[i].append(j)

    for i in range(n):
        q = Linked[i][:]
        while q:
            adj = q.pop(0)
            if adj <= i:
                continue
            if visited[adj]:
                continue
            answer -= 1
            q = q + Linked[adj]
            visited[adj] = 1
    return answer