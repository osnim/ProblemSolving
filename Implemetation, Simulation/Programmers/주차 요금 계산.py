from collections import defaultdict
import math


def compute(IN, OUT):
    inHour, inMinute = IN.split(":")
    outHour, outMinute = OUT.split(":")
    total = (int(outHour) - int(inHour)) * 60 + (int(outMinute) - int(inMinute))
    return total


def solution(fees, records):
    answer = []
    stdM, stdF, unitM, unitF = fees
    # 문자열로 된 시간 정수로 계산
    # 일단 dict 으로 차량 번호를 키로, 나가면 del로 원소 제거하기
    dic = defaultdict(str)
    acmTime = defaultdict(int)  # accumulate Time
    temp = defaultdict(int)
    for recode in records:
        time, num, IO = recode.split()
        if num not in dic:
            dic[num] = time
        else:
            elapsed = compute(dic[num], time)
            acmTime[num] += elapsed
            del dic[num]

    # 23:59분까지 나가지 않은 차 계산
    for num in dic:
        elapsed = compute(dic[num], "23:59")
        acmTime[num] += elapsed

    for num in acmTime:
        if acmTime[num] < stdM:
            temp[num] = stdF
        else:
            temp[num] = stdF + math.ceil((acmTime[num] - stdM) / unitM) * unitF

    temp = dict(sorted(temp.items()))
    for fee in temp.values():
        answer.append(fee)

    return answer