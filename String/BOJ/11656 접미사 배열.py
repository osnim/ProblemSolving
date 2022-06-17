s = input()
for s in sorted([s[i:] for i in range(len(s))]):
    print(s)