class Solution {
    public int findComplement(int num) {

        int bits = 0;
        int temp = num;

        while (temp > 0) {
            bits++;
            temp = temp >> 1;
        }

        int mask = 0;

        for (int i = 0; i < bits; i++) {
            mask = (mask << 1) | 1;
        }

        return num ^ mask;
    }
}