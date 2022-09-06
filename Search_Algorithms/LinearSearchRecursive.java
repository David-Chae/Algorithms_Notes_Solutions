// Java code for linearly searching x in arr[]. If x
// is present then return its location, otherwise
// return -1
 
class LinearSearch {
    public static int linearSearch(int arr[], int size, int x){
        if (size == 0) {
            return -1;
        }
        if (arr[size - 1] == key) {
            // Return the index of found key.
            return size - 1;
        }
        else {
            int ans = linearSearch(arr, size - 1, key);
            return ans;
        }
    }
 
    // Driver's code
    public static void main(String args[])
    {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
 
        // Function call
        int result = search(arr, arr.length, x);
        if (result == -1)
            System.out.print(
                "Element is not present in array");
        else
            System.out.print("Element is present at index "
                             + result);
    }
}
