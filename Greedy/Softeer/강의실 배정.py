import sys
import heapq as hq
input = sys.stdin.readline
N = int(input()) # 강의 개수
answer = 0
q = []
for _ in range(N):
    start, end = map(int, input().split())
    if start == end:
        answer += 1
        continue
    else:
        hq.heappush(q, (end, start)) #가장 빨리 끝내는 것 우선, 끝이 같은 경우 늦게 시작하는 경우 먼저 넣기

end, start = hq.heappop(q)
answer += 1

while q:
    e, s = hq.heappop(q)
    if end <= s:
        answer += 1
        end = e

print(answer)