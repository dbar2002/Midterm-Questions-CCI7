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
