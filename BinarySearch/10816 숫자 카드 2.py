from collections import defaultdict

def LowerBound(start, end, cards, check):
    bound = end
    while start <= end:
        mid = (start + end) // 2
        if check <= cards[mid]:
            bound = mid
            end = mid - 1
        else:
            start = mid + 1
    return bound

def UpperBoud(start, end, cards, check):
    bound = start
    while start <= end:
        mid = (start + end) // 2
        if cards[mid] <= check:
            bound = mid
            start = mid + 1
        else:
            end = mid - 1
    return bound

N = int(input())
cards = list(map(int, input().split()))
cards.sort()
M = int(input())
checks = list(map(int, input().split()))

dic = defaultdict(int)

for check in checks:
    start = 0
    end = N - 1
    cnt = 0
    if check not in dic:
        while start <= end:
            mid = (start + end) // 2
            # 먼저 원하는 값 찾기
            if check == cards[mid]:
                # mid를 중심으로 원하는 카드의 왼쪽 끝 index 찾기
                leftIdx = LowerBound(start, mid, cards, check)
                # mid를 중심으로 원하는 카드의 오른쪽 끝 index 찾기
                rightIdx = UpperBoud(mid, end, cards, check)
                # 카드의 개수
                cnt = rightIdx - leftIdx + 1
                break
            elif cards[mid] < check:
                start = mid + 1
            else:
                end = mid - 1
        dic[check] = cnt
        print(cnt, end=" ")
    else:
        print(dic[check])
