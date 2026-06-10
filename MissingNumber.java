public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5};
        int n = 5;

        // Sum of numbers from 1 to n
        int expectedSum = n * (n + 1) / 2;

        // Sum of array elements
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum = actualSum + arr[i];
        }

        // Missing number
        int missingNumber = expectedSum - actualSum;

        System.out.println("Missing Number is: " + missingNumber);
    }
}
