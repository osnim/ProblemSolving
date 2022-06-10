def solution(n, words):
    used = []
    for i, word in enumerate(words):
        if not used:
            used.append(word)
            continue
        if word in used:
            return [i % n + 1, i // n + 1]

        elif used[-1][-1] != word[0]:
            return [i % n + 1, i // n + 1]

        used.append(word)

    return [0, 0]