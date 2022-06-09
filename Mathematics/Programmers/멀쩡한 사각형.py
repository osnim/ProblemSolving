def GCD(a, b):
    while b:
        mod = a % b
        a = b
        b = mod
    return a

def solution(w, h):
    gcd = GCD(w, h)
    answer = w * h - (w + h - gcd)
    return answer