class Solution {
    public int maxDiff(int num) {
        // \U0001f680 Entry point: Convert the number to a string & kick off the maxDiff calculation!
        String s = String.valueOf(num);
        return getMax(s) - getMin(s); // \U0001f4a5 Calculate & return the difference between max & min versions.
    }

    private int getMax(String s) {
        // \U0001f947 Finding the Maximum Number: We want to make this number BIG!
        int n = s.length();
        for (int i = 0; i < n; i++) { // \U0001f6b6‍♀️ Go digit by digit...
            char c = s.charAt(i);      // \U0001f50d Look at the current digit.
            if (c < '9') {            // \U0001f4a1 Aha! If it's less than '9', there's room to grow!
                return Integer.parseInt(s.replace(c + "", "9")); // \U0001f680 Replace all occurrences of that digit with '9'!
            }
        }
        return Integer.parseInt(s); // \U0001f937‍♀️ If we didn't find anything to change, just return the original number.
    }

    private int getMin(String s) {
        // \U0001f948 Finding the Minimum Number: Let's make this number as SMALL as possible!
        int n = s.length();
        char firstDigit = s.charAt(0); // \U0001f947 First digit is special!

        if (firstDigit != '1') { // \U0001f575️‍♀️ If the first digit isn't '1',
            return Integer.parseInt(s.replace(firstDigit + "", "1")); // \U0001f680 Replace it with '1' to minimize (but not '0' to avoid leading zeros!)
        } else {
            for (int i = 1; i < n; i++) { // \U0001f6b6‍♀️ Now, check the rest of the digits
                char c = s.charAt(i);
                if (c != '0' && c != '1') { // \U0001f3af Find the first non-'0' or non-'1' to turn into '0'!
                    return Integer.parseInt(s.replace(c + "", "0")); // \U0001f680 Replace all occurrences of that digit with '0'
                }
            }

            return Integer.parseInt(s); // \U0001f937‍♀️ If nothing else to change, return the original number.
        }
    }
}