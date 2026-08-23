class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int curr : asteroids) {

            boolean alive = true;

            while (!st.isEmpty() && st.peek() > 0 && curr < 0) {

                int top = st.peek();

                if (top < Math.abs(curr)) {
                    // Top asteroid explodes
                    st.pop();
                }

                else if (top == Math.abs(curr)) {
                    // Both explode
                    st.pop();
                    alive = false;
                    break;
                }

                else {
                    // Current asteroid explodes
                    alive = false;
                    break;
                }
            }

            if (alive) {
                st.push(curr);
            }
        }

        int[] result = new int[st.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}