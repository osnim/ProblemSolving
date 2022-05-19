import sys
input = sys.stdin.readline
n, c = map(int, input().split())
LANs = [int(input().strip()) for _ in range(n)]
LANs.sort()
left = 0 #이분 탐색 범위
right = LANs[-1] #공유기 위치가 left에서 떨어진 최대 거리
ans = 0
while left <= right:
    # 인접한 두 공유기 사이의 최대 거리라고 가정
    mid = (left+right)//2
    cnt = 0
    cur = LANs[0] #인접한 공유기 위치
    for i in range(1, len(LANs)):
        dist = LANs[i] - cur
        # 답이라고 가정한 mid보다 크거나 같은 경우 공유기 설치 가능
        if dist >= mid:
            cnt += 1  # 선택된 공유기
            cur = LANs[i]
            if cnt+1 >= c:
                break
    if cnt+1 >= c: #최대 거리를 적당하게 잡거나 짧게 잡아서 공유기를 많이 선택한 경우
        left = mid + 1
        ans = mid
    else:  #최대 거리(mid)를 길게 잡아서 공유기가 남는 경우
        right = mid - 1

print(ans)
