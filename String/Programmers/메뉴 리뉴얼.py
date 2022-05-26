from collections import defaultdict
from itertools import combinations
def solution(orders, course):
    answer = []
    for cnt in course:
        combis = []
        dic = defaultdict(int)
        for order in orders:
            if len(order) >= cnt:
                combis = list(combinations(order, cnt))
                for cb in combis:
                    cb = list(cb)
                    cb.sort()
                    dic["".join(cb)] += 1

        if dic:
            print(dic)
            maxKey = max(dic, key=dic.get)
            if dic[maxKey] > 1:
                answer += [k for k, v in dic.items() if dic[maxKey] == v]
    answer.sort()
    return answer