import sys
def solve():
    start = 0
    end = 0
    answer = N+1
    temp = numbers[0]
    while end < N:
        if temp >= S:
            if answer > (end + 1 - start):
                answer = (end + 1 - start)
            temp -= numbers[start]
            start += 1
            if start > end:
                end += 1
                if end >= N:
                    break
                start -= 1
                temp += numbers[end]
        elif temp < S:
            end += 1
            if end >= N:
                break
            temp += numbers[end]

    if answer == N+1:
        answer = 0
    print(answer)
    return

if __name__ == "__main__":
    input = sys.stdin.readline
    N, S = map(int, input().split())
    numbers = list(map(int, input().split()))
    solve()



