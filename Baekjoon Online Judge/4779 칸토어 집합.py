# 4779 칸토어 집합
import sys

N = map(int, sys.stdin.read().split())


def translate_cantor(depth, position, start, end, max_depth, str_lst):
    next_point = (end - start + 1) // 3

    if depth > max_depth:
        return

    if position != "middle":
        translate_cantor(depth + 1, "start", start, start + next_point - 1, max_depth, str_lst)
        translate_cantor(depth + 1, "middle", start + next_point, start + next_point * 2 - 1, max_depth, str_lst)
        translate_cantor(depth + 1, "end", start + next_point * 2, end, max_depth, str_lst)
    else:
        str_lst[start:end + 1] = ' ' * (end - start + 1)


for i in N:
    str_list = ['-'] * (3 ** i)
    translate_cantor(0, "start", 0, len(str_list) - 1, i, str_list)
    print("".join(str_list))
