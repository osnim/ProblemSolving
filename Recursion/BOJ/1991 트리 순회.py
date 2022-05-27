import sys
from collections import defaultdict
def preOrder(parent, tree):
    if parent == ".":
        return
    sys.stdout.write(parent)
    preOrder(tree[parent][0], tree)
    preOrder(tree[parent][1], tree)
    return

def inOrder(parent, tree):
    if parent == ".":
        return
    inOrder(tree[parent][0], tree)
    sys.stdout.write(parent)
    inOrder(tree[parent][1], tree)
    return

def postOrder(parent, tree):
    if parent == ".":
        return
    postOrder(tree[parent][0], tree)
    postOrder(tree[parent][1], tree)
    sys.stdout.write(parent)
    return

input = sys.stdin.readline
N = int(input().strip())
tree = defaultdict(list)
for _ in range(N):
    parent, l, r = input().split()
    tree[parent] = [l, r]

preOrder("A", tree)
print()
inOrder("A", tree)
print()
postOrder("A", tree)