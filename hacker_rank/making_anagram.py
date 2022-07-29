#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'makeAnagram' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING a
#  2. STRING b
#

def makeAnagram(a, b):
    # Write your code here
    a_freq = [0] * 26
    b_freq = [0] * 26
    count = 0
    
    for c in a:
        a_freq[ord(c)-97]+=1
    
    for c in b:
        b_freq[ord(c)-97]+=1
        
    i = 0
    while i < 26:
        count += abs(a_freq[i] - b_freq[i])
        i+=1
    
    return count            
        
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a = input()

    b = input()

    res = makeAnagram(a, b)

    fptr.write(str(res) + '\n')

    fptr.close()
