import re
st = input()
word = input()
p = re.compile(word)
cnt = 0
while True:
    m = p.search(st)
    if not m:
        break
    cnt += 1
    st = st[m.end():]

print(cnt)