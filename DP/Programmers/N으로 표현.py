def solution(N, number):
    answer = -1
    dp = []
    if number == N:
        return 1
    for i in range(1, 9):
        numSet = set()
        numSet.add(int(str(N)*i))
        for j in range((i-1)):
            for x in dp[j]:
                for y in dp[-j-1]:
                    numSet.add(x + y)
                    numSet.add(x - y)
                    numSet.add(x * y)
                    if y != 0:
                        numSet.add(x // y)
        if number in numSet:
            return i
        dp.append(numSet)

    return answer

