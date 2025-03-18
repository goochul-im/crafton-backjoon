import sys

w, h = map(int, sys.stdin.readline().split())
prob = sys.stdin.read().splitlines()[1:]

prob = [list(map(int, s.split())) for s in prob]

w_point = [w[1] for w in prob if w[0] == 0]
h_point = [h[1] for h in prob if h[0] == 1]

w_point.sort(reverse=True)
h_point.sort(reverse=True)

w_list = []
h_list = []

# print(w_point)
# print(h_point)

for width in w_point:
    h_list.append(h-width)
    h = width

for height in h_point:
    w_list.append(w-height)
    w = height

w_list.append(w)
h_list.append(h)

# print(w_list)
# print(h_list)

print(max(w_list)*max(h_list))


