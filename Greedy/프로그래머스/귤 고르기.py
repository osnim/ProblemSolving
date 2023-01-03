from collections import defaultdict
import heapq as hq

def solution(k, tangerine):
    dic = defaultdict(int)
    q = []
    answer = 0
    for size in tangerine:
        dic[size] += 1

    for key, value in dic.items():
        hq.heappush(q, [-value, key])

    while q:
        value, key = hq.heappop(q)
        value = -value
        k -= value
        answer += 1
        if k <= 0:
            break

    return answer