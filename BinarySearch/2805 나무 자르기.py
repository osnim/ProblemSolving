n, m = map(int, input().split())
woods = list(map(int, input().split()))
woods.sort()
left = 0
right = max(woods)
ans = 0
while left <= right:
    cnt = 0
    mid = (left + right) // 2
    for wood in woods:
        if wood > mid:
            cnt += wood-mid
            if cnt >= m:
                break
    if cnt >= m: # 너무 많이 자름, 높이를 낮춰야 함
        ans = mid
        left = mid + 1
    else:
        right = mid - 1
print(ans)