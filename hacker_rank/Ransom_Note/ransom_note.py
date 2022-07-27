#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'checkMagazine' function below.
#
# The function accepts following parameters:
#  1. STRING_ARRAY magazine
#  2. STRING_ARRAY note
#
from collections import Counter

#Long version that does not use imported Counter
def checkMagazine(magazine, note):
    # Write your code here
    
    mag_freq = {}
    note_freq = {}
    
    for word in magazine:
        if word in mag_freq:
            mag_freq[word]+=1
        else:
            mag_freq[word]=1
    
    for word in note:
        if word in note_freq:
            note_freq[word]+=1
        else:
            note_freq[word]=1
    
    for key, val in note_freq.items():
        if (key in mag_freq.keys()):
            if(val > mag_freq[key]):
                print("No")
                return
        else:
            print("No")
            return
    print("Yes")
    return

#Shorter version is below
def checkMagazine(magazine, note):
    # Write your code here
    
    mag_freq = Counter(magazine)
    note_freq = Counter(note)
    
    for key, val in note_freq.items():
        if (key in mag_freq.keys()):
            if(val > mag_freq[key]):
                print("No")
                return
        else:
            print("No")
            return
    print("Yes")
    return
    
if __name__ == '__main__':
    first_multiple_input = input().rstrip().split()

    m = int(first_multiple_input[0])

    n = int(first_multiple_input[1])

    magazine = input().rstrip().split()

    note = input().rstrip().split()

    checkMagazine(magazine, note)
