from collections import defaultdict
def solution(enroll, referral, seller, amount):
    answer = []
    total = defaultdict(int)
    dic = defaultdict(str)
    total["minho"] = 0

    for name in enroll:
        total[name] = 0
    for i in range(len(referral)):
        if referral[i] == "-":
            dic[enroll[i]] = "minho"
            continue
        dic[enroll[i]] = referral[i]  # 키: 자식, 값: 부모

    for s in range(len(seller)):
        earn = amount[s] * 100
        total[seller[s]] += earn - int(earn * 0.1)
        parent = dic[seller[s]]
        earn = int(earn * 0.1)
        while parent != "minho" and earn > 0:
            total[parent] += earn - int(earn * 0.1)
            earn = int(earn * 0.1)
            parent = dic[parent]
        total[parent] += earn

    for k, v in total.items():
        if k != "minho":
            answer.append(v)

    return answer