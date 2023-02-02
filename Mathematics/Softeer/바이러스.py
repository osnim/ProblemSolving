import sys
K, P, N = map(int, input().split())
answer = K
for i in range(N):
    answer = (P * answer) % 1000000007
print(answer)