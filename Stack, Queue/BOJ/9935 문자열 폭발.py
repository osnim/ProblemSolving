import re
word = input()
boom = input()
stack = []
last = boom[-1] #폭발문자열의 마지막
n = len(boom) #폭발문자열의 길이
for s in word:
    stack.append(s)
    if s == boom[-1]:
        if ''.join(stack[-n:]) == boom:
            #for i in range(n):
                #stack.pop()
            del stack[-n:]

if not stack:
    print("FRULA")
print(''.join(stack))