import heapq as hq
from collections import deque
def solution(jobs):
    answer = 0  # 총 경과 시간
    running = 0  # 현재 시간
    start = -1  # 이것보다 커야 moment를 체크
    finishJobCnt = 0
    l = len(jobs)
    q = []

    # 작업이 빨리 끝나는 것을 우선순위로 정렬
    jobs.sort(key=lambda x: (x[1], x[0]))
    q = []
    while jobs:
        for i in range(l):
            moment, time = jobs[i][0], jobs[i][1]
            if moment <= running:
                # 시간안에 되는 작업 다 넣고 가장 빨리 끝나는 작업 1개만 수행
                moment, time = jobs.pop(i)
                hq.heappush(q, [time, moment])
        if q:
            time, moment = hq.heappop(q)
            # 다음 요청을 받아들이는 최소 시각, 바로 이전에 완료한 작업의 시작시간
            start = running
            # 총 경과 시간
            running += time
            # 총 작업이 걸린 시간 = (끝난시간 - 요청 시간)
            answer += (running - moment)
            # print(answer)
            finishJobCnt += 1
        else:
            running += 1

    # print(answer//l)
    return answer // l

solution([[0, 3], [1, 9], [2, 6]])