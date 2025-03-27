# 1991 트리 순회
import sys

N = int(sys.stdin.readline())

prob = [None] * N
for _ in range(N):
    temp = list(sys.stdin.readline().split())
    idx = ord(temp[0]) - 65
    prob[idx] = ([ord(i) - 65 if i != '.' else None for i in temp[1:]])

preorder_msg = ""
inorder_msg = ""
postorder_msg = ""


def preorder(num: int = 0):
    global preorder_msg
    preorder_msg += f"{chr(num + 65)}"
    for p in prob[num]:
        if p is not None:
            preorder(p)


def inorder(num: int = 0):
    global inorder_msg
    if prob[num][0] is not None:
        inorder(prob[num][0])
    inorder_msg += f"{chr(num + 65)}"
    if prob[num][1] is not None:
        inorder(prob[num][1])


def postorder(num:int=0):
    global postorder_msg
    for p in prob[num]:
        if p is not None:
            postorder(p)
    postorder_msg += f"{chr(num + 65)}"


preorder()
inorder()
postorder()
print(preorder_msg)
print(inorder_msg)
print(postorder_msg)
