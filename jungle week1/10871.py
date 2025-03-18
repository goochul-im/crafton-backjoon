import sys

n = int(sys.stdin.readline().split()[1])
prob = map(int, sys.stdin.readline().split())

prob = [x for x in prob if x < n]
print(" ".join(map(str, prob))) # join은 숫자 리스트에서는 적용되지 않으므로 문자열로 바꿔야 함
