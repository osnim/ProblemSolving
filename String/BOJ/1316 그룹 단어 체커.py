import sys
input = sys.stdin.readline
N = int(input())
answer = 0
for i in range(N):
    word = input().strip()
    check = []
    Flag = True
    for j in range(len(word)-1):
        if word[j] == word[j+1]:
            continue
        if word[j] in word[j + 1:]:
            Flag = False
            break
        check.append(word[j])

    if word[-1] not in check and Flag:
        answer += 1

print(answer)
