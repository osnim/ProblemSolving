import re
from itertools import permutations
def compute(expression, p, i):
    return

def solution(expression):
    answer = 0
    per = list(permutations(["+", "-", "*"], 3))
    ex = re.split("([\+\-\*])", expression)
    print(ex)
    for p in per:
        for op in p:
            if op in ex:
                i = ex.index(op) # op의 인덱스를 찾음
                ex[i-1] = str(eval(ex[i-1] + ex[i] + ex[i+1]))
                del ex[i:i+2]
                print(ex)

    return answer