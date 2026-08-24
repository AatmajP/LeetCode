

class Solution {
    public int nextGreaterElement(int n) {

        char[] arr = String.valueOf(n).toCharArray();

        
        int i = arr.length - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

  
        int j = arr.length - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }

       
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        
        Arrays.sort(arr, i + 1, arr.length);

 
        long result = Long.parseLong(new String(arr));

        if (result > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) result;
    }
}
