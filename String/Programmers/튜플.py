from collections import defaultdict
def solution(s):
    answer = []
    temp = "".join(s.split("}"))
    temp = "".join(temp.split("{"))
    temp = temp.split(",")
    dic = defaultdict(int)
    for i in temp: #숫자만 세기
        dic[i] += 1

    #가장 많은 개수를 포함한 원소부터 찾아  answer에 넣기
    maxKey = max(dic, key=dic.get)
    n = dic[maxKey]
    for _ in range(n):
        maxKey = max(dic, key=dic.get)
        answer.append(int(maxKey))
        del dic[maxKey]

    return answer