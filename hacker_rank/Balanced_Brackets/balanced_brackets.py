#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'isBalanced' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def isBalanced(s):
    # Write your code here
    stack = []
    
    for c in s:
        if len(stack) == 0:
            stack.append(c)
        else:
            if stack[-1] == '(' and c == ')':
                stack.pop()
            elif stack[-1] == '{' and c == '}':
                stack.pop()
            elif stack[-1] == '[' and c == ']':
                stack.pop()
            else:
                stack.append(c)
    
    if len(stack) == 0: return "YES"
    
    return "NO"
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
