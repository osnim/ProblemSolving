def solution(k, ranges):
    answer = []
    sumArr = [0]
    K = k

    while k > 1:
        temp = k
        if k % 2 == 0:
            k //= 2
        else:
            k = k * 3 + 1
        sumArr.append((temp + k) / 2 + sumArr[-1])
    end = len(sumArr) - 1
    for x, y in ranges:
        y += end
        if x > y:
            answer.append(-1)
        elif x == y:
            answer.append(0)
        else:
            answer.append(sumArr[y] - sumArr[x])
    return answer