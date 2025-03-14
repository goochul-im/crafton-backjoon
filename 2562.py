import sys

prob = list(map(int, sys.stdin.read().split())) # 한번에 모든 입력을 받아서 split 후 int 형으로 바꾸면서 list로 또 바꿈
# 이 때 터미널에서는 ctrl + D 를 입력해줘야함
# 백준에서는 자동으로 EOF가 들어가는듯

val = max(prob)
print(val)
print(prob.index(val)+1)
