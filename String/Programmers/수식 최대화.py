import re
from itertools import permutations
def solution(expression):
    answer = 0
    per = list(permutations(["+", "-", "*"], 3))
    expression = re.split("([\+\-\*])", expression)
    print(expression)
    for p in per:
        ex = expression[:]
        for op in p:
            while op in ex:
                i = ex.index(op)  # op의 인덱스를 찾음
                ex[i - 1] = str(eval(ex[i - 1] + ex[i] + ex[i + 1]))
                del ex[i:i + 2]

        answer = max(answer, abs(int("".join(ex))))
    return answer