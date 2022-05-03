def solution(clothes):
    answer = 1
    dic = {category: 0 for name, category in clothes}

    for name, category in clothes:
        dic[category] += 1

    if len(dic) == 1:
        print(dic[category])
        answer = dic[category]
        return answer

    for k in dic.keys():
        answer *= (dic[k] + 1)

    answer -= 1
    return answer