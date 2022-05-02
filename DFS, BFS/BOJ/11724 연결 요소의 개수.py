import sys
from collections import deque
#특정 원소가 속한 집합 찾기
def BFS(arr, start, visited):
    q = deque([start])
    visited[start] = 1
    cnt = 0
    while q:
        x = q.popleft()
        for end in arr[x]:
            if not visited[end]:
                q.append(end)
                visited[end] = 1
                cnt += 1
    return cnt
def solve():
    if M == 0:
        print(N)
        return

    for i in range(M):
        v1, v2 = map(int, input().split())
        arr[v1].append(v2)
        arr[v2].append(v1)

    visited = [0] * (N + 1)
    cnt = 0
    for i in range(1, N+1):
        if arr[i]:
            if not visited[i]:
                cnt += BFS(arr, i, visited)
    print(N-cnt)
    return

if __name__ =="__main__":
    input = sys.stdin.readline
    N, M = map(int, input().split())
    arr = [[] for i in range(N + 1)]
    solve()