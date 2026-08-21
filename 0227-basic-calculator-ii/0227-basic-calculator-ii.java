class Solution {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();

        int n = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') ||
                i == s.length() - 1) {

                if (op == '+') {
                    st.push(n);
                }
                else if (op == '-') {
                    st.push(-n);
                }
                else if (op == '*') {
                    st.push(st.pop() * n);
                }
                else if (op == '/') {
                    st.push(st.pop() / n);
                }

                op = ch;
                n = 0;
            }
        }

        int result = 0;

        while (!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }
}