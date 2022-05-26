from collections import deque
import sys
input = sys.stdin.readline
N, K = map(int, input().split())
if N == K:
    print(0)
    exit()
q = deque([])
q.append([N, 0])
visited = [0]*100001
visited[N] = 1

while q:
    i, t = q.popleft()
    if 0 <= i - 1 <= 100000:
        if i - 1 == K:
            print(t+1)
            break
        if not visited[i-1]:
            q.append([i - 1, t+1])
            visited[i - 1] = 1
    if 0 <= i + 1 <= 100000:
        if i + 1 == K:
            print(t + 1)
            break
        if not visited[i+1]:
            q.append([i + 1, t+1])
            visited[i+1] = 1
    if 0 <= i * 2 <= 100000:
        if i * 2 == K:
            print(t + 1)
            break
        if not visited[i*2]:
            q.append([i*2, t+1])
            visited[i*2] = 1
