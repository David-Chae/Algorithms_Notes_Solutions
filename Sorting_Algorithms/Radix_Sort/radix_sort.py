  def bit_value(number, bit):
    '''
    Returns the value of the bit at index 'bit' in 'number'
    '''
    mask = 1 << bit
    if number & mask != 0:
        return 1
    return 0

def counting_sort(the_list, bit):
    '''
    Arrange the items in the_list based on the value of
    a specific bit. This doesn't fully sort the list (it
    just sorts by a specific bit), but we'll use it for radix
    sort.
    '''

    # counts[0] stores the number of items with a 0 in this bit
    # counts[1] stores the number of items with a 1 in this bit
    counts = [0, 0]
    for item in the_list:
        counts[ bit_value(item, bit) ] += 1

    # indices[0] stores the index where we should put the next item
    # with a 0 in this bit.
    # indices[1] stores the index where we should put the next item
    # with a 1 in this bit.
    #
    # The items with a 0 in this bit come at the beginning (index 0).
    # The items with a 1 in this bit come after all the items with a 0.
    indices = [0, counts[0]]

    # Output list to be filled in
    sorted_list = [None] * len(the_list)

    for item in the_list:

        item_bit_value = bit_value(item, bit)

        # Place the item at the next open index for its bit value
        sorted_list[ indices[item_bit_value] ] = item

        # The next item with the same bit value goes after this item
        indices[item_bit_value] += 1

    return sorted_list

def radix_sort(the_list):
    '''
    Use counting sort to arrange the numbers, from least significant
    bit to most significant bit.
    '''

    for bit_index in xrange(64):
        the_list = counting_sort(the_list, bit_index)

    return the_list
