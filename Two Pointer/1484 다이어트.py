import sys

def solve():
    curWeight = 1
    memoWeight = 1
    answer = []
    if G < 3:
        print(-1)
        return
    while True:
        powDiff = curWeight ** 2 - memoWeight ** 2
        diff = curWeight - memoWeight
        # 몸무게 차이가 1이하 이면서 G보다 크면 종료
        if powDiff > G:
            if diff == 1:
                break
            memoWeight += 1

        elif powDiff == G:
            answer.append(curWeight)
            memoWeight += 1

        elif powDiff < G:
            curWeight += 1

    if answer:
        for i in answer:
            print(i)
    else:
        print(-1)
    return

if __name__=="__main__":
    input = sys.stdin.readline
    G = int(input().strip())
    solve()