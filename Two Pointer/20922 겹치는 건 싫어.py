ans = 0
count = [0]*(100000+1)
N, K = map(int, input().split())

arr = list(map(int, input().split()))
dp = [0] * (N+1)
left, right = 0, 0
while(right < N):
    curNum = arr[right]
    count[curNum] += 1

    if count[curNum] > K:
        while(left <= right):
            leftNum = arr[left]
            count[leftNum] -= 1
            left += 1
            if curNum == leftNum:
                break
    else:
        ans = max(ans, right - left + 1)
    right += 1
print(ans)