//10.11 Peaks and Valleys: In an array of integers, a "peak" is an element which is greater than or equal to
//the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers. For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an array
//of integers, sort the array into an alternating sequence of peaks and valleys.
//EXAMPLE
//Input: {5, 3, 1, 2, 3}
//Output: {5, 1, 3, 2, 3}

import java.util.Arrays;

public class PeaksAndValleys {
    public static int[] sortPeaksAndValleys(int[] arr) {
        Arrays.sort(arr); // Sort the input array in ascending order
        int[] result = new int[arr.length];
        int low = 0;
        int high = arr.length - 1;
        boolean isLow = true;

        for (int i = 0; i < arr.length; i++) {
            if (isLow) {
                result[i] = arr[low];
                low++;
            } else {
                result[i] = arr[high];
                high--;
            }
            isLow = !isLow; // Toggle between low and high
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {5, 3, 1, 2, 3};
        int[] output = sortPeaksAndValleys(input);

        System.out.println("Input Array: " + Arrays.toString(input));
        System.out.println("Output Array: " + Arrays.toString(output));
    }
}
