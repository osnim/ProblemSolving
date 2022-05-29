import sys
def getLCS(arr, n, m):
    i, j = n, m
    ans = ""
    while arr[i][j] != 0:
        if arr[i][j] == 1:
            ans += s1[i]
            i, j = i - 1, j - 1
        elif arr[i][j] == 2:
            i -= 1
        else:
            j -= 1
    return ans[::-1]

input = sys.stdin.readline
s1 = " " + input().strip()
s2 = " " + input().strip()
n, m = len(s1)-1, len(s2)-1
dp = [[0]*(m+1) for _ in range(n+1)]
#왔던 길을 다시 돌아가 LCS의 문자들을 찾음
backTrack = [[0]*(m+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, m+1):
        if s1[i] == s2[j]:
            dp[i][j] = dp[i-1][j-1] + 1
            backTrack[i][j] = 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
            backTrack[i][j] = 2 if dp[i-1][j] > dp[i][j-1] else 3
print(dp[n][m])
print(getLCS(backTrack, n, m))