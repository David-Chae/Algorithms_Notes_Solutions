#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'arrayManipulation' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY queries
#

def arrayManipulation(n, queries):
    # Write your code here
    array = [0]*n
    
    for i in range(len(queries)):
        start = queries[i][0]-1
        end = queries[i][1]-1
        num = queries[i][2]
        array[start] += num
        if (end+1) < n: 
            array[end+1] -= num
    
    max_num = -sys.maxsize
    curr = 0
    ptr = 0
    
    while ptr < n:
        curr += array[ptr]            
        if curr > max_num:
            max_num = curr
        ptr+=1
    
    return max_num
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    m = int(first_multiple_input[1])

    queries = []

    for _ in range(m):
        queries.append(list(map(int, input().rstrip().split())))

    result = arrayManipulation(n, queries)

    fptr.write(str(result) + '\n')

    fptr.close()
