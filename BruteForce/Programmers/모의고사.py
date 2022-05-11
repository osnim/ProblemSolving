def solution(answers):
    ans = []
    giveup1 = [1, 2, 3, 4, 5]
    giveup2 = [2, 1, 2, 3, 2, 4, 2, 5]
    giveup3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    cnt = [0, 0, 0]

    for i in range(len(answers)):
        temp = i
        temp %= len(giveup1)
        if answers[i] == giveup1[temp]:
            cnt[0] += 1
        temp = i
        temp %= len(giveup2)
        if answers[i] == giveup2[temp]:
            cnt[1] += 1
        temp = i
        temp %= len(giveup3)
        if answers[i] == giveup3[temp]:
            cnt[2] += 1

    print(cnt)
    for i, s in enumerate(cnt):
        if s == max(cnt):
            ans.append(i + 1)

    return ans