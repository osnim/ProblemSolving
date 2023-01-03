import heapq as hq

def solution(n, k, enemy):
    global answer
    q = []
    end = len(enemy)
    left = 0
    while left < end:
        e = enemy[left]
        if n >= e:  # 병사가 적보다 많은 경우
            hq.heappush(q, -e)
            n -= e

        else:  # 병사가 적보다 적은 경우
            if k > 0:  # 무적권을 사용할 수 있는 경우
                k -= 1
                if q:
                    maxEnemy = -hq.heappop(q)
                    if e > maxEnemy:
                        hq.heappush(q, -maxEnemy)
                    else:
                        n += maxEnemy
                        n -= e
                        hq.heappush(q, -e)
            else:
                break  # 무적권도 없고 병사도 적은 경우
        left += 1
    return left