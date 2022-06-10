from collections import defaultdict
def solution(str1, str2):
    S1, S2 = defaultdict(int), defaultdict(int)
    str1, str2 = str1.upper(), str2.upper()
    l1, l2 = len(str1), len(str2)
    for i in range(l1 - 1):
        if str1[i].isalpha() and str1[i + 1].isalpha():
            S1[str1[i] + str1[i + 1]] += 1
    for i in range(l2 - 1):
        if str2[i].isalpha() and str2[i + 1].isalpha():
            S2[str2[i] + str2[i + 1]] += 1

    if not S2 and not S1:
        return 65536

    # 굳이 집합으로 안 해도 되지만 안에 문자들이 제대로 들어가는지 확인하기 위해 글자들을 일부러 넣음
    intersection = []
    sumofSet = []

    for k, v in S1.items():
        if k in S2:
            intersection += [k] * min(v, S2[k])  # 교집합, 개수 적은 것
            sumofSet += [k] * max(v, S2[k])  # 합집합, 개수 많은 것
        else:
            sumofSet += [k] * v  # 원소가 없는 경우
    for k, v in S2.items():
        if k in sumofSet:
            continue
        sumofSet += [k] * v  # 원소가 없는 경우
    return int((len(intersection) / len(sumofSet)) * 65536)
