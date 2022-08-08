from collections import Counter
import sys
input = sys.stdin.readline
N = int(input().strip())
arr = []
S = 0
for _ in range(N):
    temp = int(input().strip())
    arr.append(temp)
    S += temp

arr.sort()
print(int("%.0f" % (S / N)))  # 산술평균
print(arr[N // 2])  # 중앙값

# 최빈값
nums = Counter(arr).most_common()
if N > 1:
    if nums[0][1] == nums[1][1]:
        print(nums[1][0])
    else:
        print(nums[0][0])
else:
    print(arr[0])

print(arr[-1] - arr[0])  # 범위
