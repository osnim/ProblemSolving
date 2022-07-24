from collections import deque
for _ in range(int(input())):
    N, M = map(int, input().split())
    q = deque(list(map(int, input().split())))
    check = deque([0] * N)
    check[M] = 1
    cnt = 0
    while True:
        if q[0] == max(q):
            q.popleft()
            cnt += 1

            if check.popleft() == 1: #우리가 찾는 위치가 처음
                print(cnt)
                break
        else:
            q.rotate(-1)
            check.rotate(-1)
