'''
걸린 시간: 약 1시간
좀 더 빨리 풀어야하고 처음 문제를 접하면 특별한 알고리즘이 필요할 줄 알고 혼자서 어렵게 생각함
처음에는 분할 정복을 생각했으나 이렇게 하면 시간초과가 발생할 것 같아 다시 생각함
딕셔너리 두 개, 반복문 두 번 돌리니 해결함
'''

from collections import defaultdict

def solution(topping):
    answer = 0
    n = len(topping)

    leftDict = defaultdict(int)
    leftDict[topping[0]] += 1

    rightDict = defaultdict(int)

    for i in range(1, n):
        t = topping[i]
        rightDict[t] += 1

    for i in range(1, n):
        t = topping[i]
        leftDict[t] += 1
        rightDict[t] -= 1
        if rightDict[t] == 0:
            del rightDict[t]
        if len(leftDict) == len(rightDict):
            answer += 1

    return answer