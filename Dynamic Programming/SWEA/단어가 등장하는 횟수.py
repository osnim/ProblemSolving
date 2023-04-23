def get_partial_match(s):
    length = len(s)
    pi = [0] * length
    j = 0
    for i in range(1, length):
        while j > 0 and s[i] != s[j]:
            j = pi[j-1]
        if s[i] == s[j]:
            j += 1
            pi[i] = j
    return pi

def kmp(s, pattern):
    pi = get_partial_match(pattern)
    j = 0
    cnt = 0
    for i in range(len(s)):
        while j > 0 and s[i] != pattern[j]:
            j = pi[j-1]
        if s[i] == pattern[j]:
            if j == len(pattern)-1:
                cnt += 1
                j = pi[j]
            else:
                j += 1
    return cnt

T = int(input())
for t in range(1, T+1):
    content = input()
    pattern = input()
    cnt = kmp(content, pattern)
    print(f'#{t} {cnt}')