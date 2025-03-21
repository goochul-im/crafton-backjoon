import sys

prob = sys.stdin.readline().strip()
stack = []


def find():
    for char in prob:
        if char == '(' or char == '[':  # 여는 괄호는 그냥 추가
            stack.append(char)
        elif char == ')':  # ')' 처리를 위한 로직
            if not stack:  # 🚨 스택이 비어 있으면 에러 방지
                print(0)
                return
            if isinstance(stack[-1], int):  # 숫자가 맨 위에 있으면
                num = stack.pop()
                if not stack or stack.pop() != '(':  # 🚨 pop() 전에 스택 체크
                    print(0)
                    return
                stack.append(num * 2)
            else:
                if stack.pop() != '(':  # 🚨 pop() 전에 스택 체크
                    print(0)
                    return
                stack.append(2)

            if len(stack) > 1 and isinstance(stack[-2], int):
                stack.append(stack.pop() + stack.pop())

        elif char == ']':  # ']' 처리를 위한 로직
            if not stack:  # 🚨 스택이 비어 있으면 에러 방지
                print(0)
                return
            if isinstance(stack[-1], int):  # 숫자가 맨 위에 있으면
                num = stack.pop()
                if not stack or stack.pop() != '[':  # 🚨 pop() 전에 스택 체크
                    print(0)
                    return
                stack.append(num * 3)
            else:
                if stack.pop() != '[':  # 🚨 pop() 전에 스택 체크
                    print(0)
                    return
                stack.append(3)

            if len(stack) > 1 and isinstance(stack[-2], int):
                stack.append(stack.pop() + stack.pop())

    if len(stack) == 1 and isinstance(stack[0], int):  # 정상적인 경우
        print(stack[0])
    else:
        print(0)  # 🚨 스택에 괄호가 남아있으면 0 출력


find()
