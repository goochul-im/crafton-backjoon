import sys

case = list(sys.stdin.read().splitlines()[:-1])
prob = [list(map(int, x.split()[1:])) for x in case]


def find(cur_list: list):
    cur_list.append(0)  # 마지막 요소 추가하여 모든 요소를 처리할 수 있도록 함
    stack = []
    result = 0

    for i in range(len(cur_list)):
        while stack and cur_list[stack[-1]] > cur_list[i]:
            height = cur_list[stack.pop()]
            width = i if not stack else i - stack[-1] - 1
            result = max(result, height * width)
        stack.append(i)

    print(result)


for p in prob:
    find(p)
