#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumBribes' function below.
#
# The function accepts INTEGER_ARRAY q as parameter.
#

def minimumBribes(q):
    # Write your code here
    swaps = 0;
    i = len(q) - 1;
    while i >= 0:
        if q[i] != i+1:
            if (i-1) >= 0 and q[i-1] == i+1:
                temp = q[i-1]
                q[i-1] = q[i]
                q[i] = temp
                swaps+=1
            elif (i-2) >= 0 and q[i-2] == (i+1):
                temp = q[i-2]
                q[i-2] = q[i-1]
                q[i-1] = temp
                temp = q[i]
                q[i] = q[i-1]
                q[i-1] = temp
                swaps+=2
            else:
                print("Too chaotic")
                return
        i-=1
    print(swaps)
    

if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
