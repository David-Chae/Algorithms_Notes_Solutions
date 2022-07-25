#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumSwaps function below.
def minimumSwaps(arr):
    index, swaps = 0, 0
    
    while index < len(arr):
        if arr[index] != index+1:
            temp = arr[index]
            arr[index] = arr[temp-1]
            arr[temp-1] = temp
            swaps+=1
        else:
            index+=1
    
    return swaps

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    res = minimumSwaps(arr)

    fptr.write(str(res) + '\n')

    fptr.close()
