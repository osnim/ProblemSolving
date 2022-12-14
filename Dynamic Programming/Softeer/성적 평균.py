import sys
input = sys.stdin.readline
print = sys.stdout.write

N, K = map(int, input().split())
S = list(map(int, input().split()))
dp = [0] * (N+1)
for i in range(N):
    dp[i+1] = dp[i] + S[i]

for _ in range(K): #구간의 성적 평균 구하기
    begin, end = map(int, input().split())
    avg = round((dp[end] - dp[begin-1])/(end-begin+1), 2)
    print(f"{avg} \n")
