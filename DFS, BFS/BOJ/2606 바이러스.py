import sys
from collections import deque

if __name__=="__main__":
    input = sys.stdin.readline
    n = int(input().strip())
    edges = int(input().strip())
    arr = [[] for _ in range(n+1)]
    visited = [0] * (n+1)
    for i in range(edges):
        start, end = map(int, input().split())
        arr[start].append(end)
        arr[end].append(start)

    if not arr[1]:
        print(1)
        exit()

    q = deque([])
    q += arr[1]
    visited[1] = 1
    while q:
        end = q.popleft()
        #print(type(end))
        if visited[end]:
            continue
        visited[end] = 1
        q += arr[end]
    print(sum(visited)-1)