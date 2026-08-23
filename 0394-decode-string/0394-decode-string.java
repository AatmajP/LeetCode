class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        int number = 0;
        String currentString = "";

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

          
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

 
            else if (ch == '[') {

                countStack.push(number);
                stringStack.push(currentString);

                number = 0;
                currentString = "";
            }

            else if (Character.isLetter(ch)) {
                currentString += ch;
            }

            
            else if (ch == ']') {

                int count = countStack.pop();
                String previousString = stringStack.pop();

                String repeated = "";

                for (int j = 0; j < count; j++) {
                    repeated += currentString;
                }

                currentString = previousString + repeated;
            }
        }

        return currentString;
    }
}