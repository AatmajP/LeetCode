class Solution {
    public boolean validUtf8(int[] data) {

        int remaining = 0;

        for (int i = 0; i < data.length; i++) {

            if (remaining > 0) {

                if ((data[i] & 192) != 128) {
                    return false;
                }

                remaining--;

            } else {

                // 1-byte character
                if ((data[i] & 128) == 0) {
                    remaining = 0;
                }

                // 2-byte character
                else if ((data[i] & 224) == 192) {
                    remaining = 1;
                }

                // 3-byte character
                else if ((data[i] & 240) == 224) {
                    remaining = 2;
                }

                // 4-byte character
                else if ((data[i] & 248) == 240) {
                    remaining = 3;
                }

                else {
                    return false;
                }
            }
        }

        return remaining == 0;
    }
}