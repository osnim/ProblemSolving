import sys
input = sys.stdin.readline
string = input().strip()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
cnt = 0
for alpha in croatia:
    string = string.replace(alpha, '*')
print(len(string))