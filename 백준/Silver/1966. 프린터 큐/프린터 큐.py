# 1966 프린터 큐
import sys
from collections import deque

case = int(sys.stdin.readline())


class Document:
    def __init__(self, is_check, val):
        self.is_check = is_check
        self.val = val


for _ in range(case):
    N, M = map(int, sys.stdin.readline().split())
    prob = list(map(int, sys.stdin.readline().split()))
    document_list = deque()
    for p in range(N):
        is_check = False
        if p == M:
            is_check = True
        document_list.append(Document(is_check, prob[p]))
    idx = 1
    while True:
        max_val = max(document_list, key=lambda x: x.val).val  # 최대값
        doc = document_list[0]  # 체크할 문서
        if doc.is_check and doc.val == max_val:
            print(idx)
            break
        if doc.val == max_val:
            document_list.popleft()
            idx += 1
        else:
            document_list.append(document_list.popleft())
