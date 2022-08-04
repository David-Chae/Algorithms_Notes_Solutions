#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'largestRectangle' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY h as parameter.
#


# I had to watch several solution videos on Youtube for an hour and a half to understand the algorithm.
# Following is the video that finally helped to make sense.
# https://www.youtube.com/watch?v=zx5Sw9130L0

def largestRectangle(h):
    # Write your code here
    maxArea = 0
    stack = [] 
    
    for i, j in enumerate(h):
        start = i
        while stack and stack[-1][1] > j:
            index, height = stack.pop()
            maxArea = max(maxArea, height * (i-index))
            start = index
        stack.append((start, j))
    
    for i, j in stack:
        maxArea = max(maxArea, j * (len(h)-i))

    return maxArea

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    h = list(map(int, input().rstrip().split()))

    result = largestRectangle(h)

    fptr.write(str(result) + '\n')

    fptr.close()
