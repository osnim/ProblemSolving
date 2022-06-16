s = input()
cnt = 0
while len(s) != 1:
    s = str(sum(map(int, list(s)))) #모든 자리수 더하고 다시 문자열로 변경
    cnt += 1 # 카운트
print(cnt)
if int(s) % 3 == 0:
    print("YES")
else:
    print("NO")