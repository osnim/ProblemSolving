import heapq
def solution(scoville, K):
    answer = 0
    q = []
    for i in scoville:
        heapq.heappush(q, i)
    while len(q) > 1:
        if q[0] >= K:
            break
        food1, food2 = heapq.heappop(q), heapq.heappop(q)
        scoville = food1 + food2 * 2
        heapq.heappush(q, scoville)
        answer += 1
    if q[0] < K:
        answer = -1
    return answer