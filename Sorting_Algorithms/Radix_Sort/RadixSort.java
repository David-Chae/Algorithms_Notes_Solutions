
public class RadixSort{

/*
 * Returns the value of the bit at index 'bit' in 'number'
 */
private static int bitValue(int number, int bit) {
    int mask = 1 << bit;
    if ((number & mask) != 0) {
        return 1;
    }
    return 0;
}

/*
 * Arrange the items in theArray based on the value of
 * a specific bit. This doesn't fully sort the array (it
 * just sorts by a specific bit), but we'll use it for radix
 * sort.
 */
private static int[] countingSort(int[] theArray, int bit) {

    // counts[0] stores the number of items with a 0 in this bit
    // counts[1] stores the number of items with a 1 in this bit
    int[] counts = new int[]{0, 0};
    for (int item : theArray) {
        counts[ bitValue(item, bit) ] += 1;
    }

    // indices[0] stores the index where we should put the next item
    // with a 0 in this bit.
    // indices[1] stores the index where we should put the next item
    // with a 1 in this bit.
    //
    // the items with a 0 in this bit come at the beginning (index 0).
    // the items with a 1 in this bit come after all the items with a 0.
    int[] indices = new int[]{0, counts[0]};

    // output array to be filled in
    int[] sortedArray = new int[theArray.length];

    for (int item : theArray) {

        int itemBitValue = bitValue(item, bit);

        // place the item at the next open index for its bit value
        sortedArray[ indices[itemBitValue] ] = item;

        // the next item with the same bit value goes after this item
        indices[itemBitValue] += 1;
    }

    return sortedArray;
}

/*
 * Use counting sort to arrange the numbers, from least significant
 * bit to most significant bit.
 */
public static int[] radixSort(int[] theArray) {

    for (int bitIndex = 0; bitIndex < 64; bitIndex++) {
        theArray = countingSort(theArray, bitIndex);
    }
    return theArray;
  }
}
