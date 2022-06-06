import re
temp = re.split('(<.+?>)', input())
ans = ""
for s in temp:
    if not s:
        continue
    if s[0] == "<":
        ans += s
        continue
    temp = ""
    for ss in s:
        if ss == " ":
            ans += temp[::-1]
            ans += " "
            temp = ""
            continue
        temp += ss
    ans += temp[::-1]

print(ans)