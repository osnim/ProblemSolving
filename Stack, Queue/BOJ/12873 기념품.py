'''----------첫번째 풀이------------'''
from collections import deque
N = int(input()) # 참가자 수

t = 1 # t단계인 경우 t^3까지 진행 > 최종 1명 남을 때 까지 진행
q = deque([])
for i in range(N):
    q.append(i+1)

for _ in range(N-1):
    t3 = (t * t * t)%(len(q))
    cur = 1
    while cur <= t3:
        q.rotate(-1)
        cur += 1
    q.rotate(1)
    q.popleft() #제외
    t += 1

print(q[0])

'''----------두번째 풀이------------'''
N = int(input()) # 참가자 수
arr = [i for i in range(1, N+1)]
delIdx = 0
for stage in range(1, N):
    delIdx = (stage * stage * stage + delIdx - 1)%len(arr)
    del arr[delIdx] #제외

print(arr[0])

