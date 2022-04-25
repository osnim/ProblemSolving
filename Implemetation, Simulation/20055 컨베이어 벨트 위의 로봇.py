from collections import deque
N, K = map(int, input().split())
belt = deque(list(map(int, input().split())))
robots = deque([0] * N)
stage = 0
empty = 0

while True:
    stage += 1
    #벨트와 로봇 함께 회전
    belt.rotate(1)
    robots.rotate(1)
    robots[N-1] = 0

    #로봇 한 칸 이동
    for ri in range(N-2, -1, -1):
        if robots[ri] == 0:
            continue
        # 내구도가 0 이상, 앞에 로봇 없는 경우
        if belt[ri+1] > 0 and not robots[ri+1]:
            robots[ri] = 0
            ri += 1
            belt[ri] -= 1
            if belt[ri] == 0:
                empty += 1
        # N번째 칸이 아닐때만
        if ri != N - 1:
            robots[ri] = 1

    #로봇 추가
    if belt[0] > 0:
        belt[0] -= 1
        robots[0] = 1
        if belt[0] == 0:
            empty += 1

    if empty >= K:
        print(stage)
        break