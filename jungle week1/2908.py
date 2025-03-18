import sys

prob = sys.stdin.readline().split()

print(max(int(prob[0][::-1]), int(prob[1][::-1]))) # [::-1]은 처음부터 끝까지 거꾸로 하나 스텝씩, 따라서 문자열이 거꾸로 됨
