# 1541 잃어버린 괄호
import sys, re

temp = sys.stdin.readline()

tokens = re.findall(r'\d+|[+-]', temp)

total = 0

IDX = 0
while IDX < len(tokens):
    if tokens[IDX] == '-':
        IDX += 1
        temp_sub = 0
        while IDX < len(tokens):
            if tokens[IDX] == '-':
                break
            elif tokens[IDX] == '+':
                IDX += 1
                continue
            else:
                temp_sub += int(tokens[IDX])
                IDX += 1
        total -= temp_sub
    elif tokens[IDX] == '+':
        IDX += 1
        continue
    else:
        total += int(tokens[IDX])
        IDX += 1

print(total)
