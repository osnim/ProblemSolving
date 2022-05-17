N = int(input())
cards = list(map(int, input().split()))
cards.sort()
M = int(input())
checks = list(map(int, input().split()))
for check in checks:
    start = 0
    end = N - 1
    cnt = 0
    while start <= end:
        mid = (start + end) // 2
        # 먼저 원하는 값 찾기
        if check == cards[mid]:
            cnt = cards[start:end+1].count(check)
            break
        elif cards[mid] < check:
            start = mid + 1
        else:
            end = mid - 1
    print(cnt, end=" ")