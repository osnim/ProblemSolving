N = int(input())
A, B = map(int, input().split())
M = int(input())

arr = [[] for _ in range(N+1)]
visited = [0]*(N+1)
result = [0] * (N+1) #A에서 각 노드와의 거리를 저장한 배열
for _ in range(M):
    x, y = map(int, input().split())
    arr[x].append(y)
    arr[y].append(x)

def dfs(start, depth):
    visited[start] = 1
    for end in arr[start]:
        if not visited[end]:
            result[end] = depth + 1
            dfs(end, depth+1)

dfs(A, 0)
if result[B]>0:
    print(result[B])
else:
    print(-1)



