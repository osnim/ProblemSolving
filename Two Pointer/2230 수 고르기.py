import sys

def solve():
    start = 0
    end = 0
    answer = 2000000000
    while end < N:
        subtraction = abs(arr[end] - arr[start])
        if subtraction >= M:
                if answer >= subtraction:
                    answer = subtraction
                start += 1
                if start > end:
                    start -= 1
                    end += 1

        elif subtraction < M:
            end += 1
    print(answer)
    return

if __name__=="__main__":
    input = sys.stdin.readline
    N, M = map(int, input().split())
    arr = []
    for i in range(N):
        arr.append(int(input()))
    arr.sort()
    solve()