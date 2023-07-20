package com.example.romancalculator;

public class Roman {

    /**Converts a short number into a Roman numeral
     * @param n The short number that will be converted to a Roman numeral
     * @return The Roman numeral equivalent of the short n
     * @throws RomanException checks for invalid numerical values such as negative numbers
     */

    public static String convertToRoman (short n) throws RomanException {
        if (n <= 0) {
            throw new RomanException("You passed " + n + " Only positive numbers allowed!!!");
        }
        if (n >= 5000) {
            throw new RomanException("NUMBER OUT OF BOUNDS!");
        }

        /**Arrays that contain the letters used to represent each section in a Roman Numeral
         * ones, tens, hundreds, and thousands
         * Also a counter variable
         */

        String[] ones = {"I", "V", "X"};
        String[] tens = {"X", "L", "C"};
        String[] hundreds = {"C", "D", "M"};
        String[] thousands = {"M"};
        String romanNum = "";
        int counter = 0;

        //todo

        return "";
    }

    public static short findIndex (char letter, String[] romanLetters) {
        for (short i = 0; i < romanLetters.length; i++) {
            if (letter == romanLetters[i].charAt(0)) {
                return i;
            }
        }
        return -1;
    }

    public static short convertToInt (String romanNumber) throws RomanException {
        //Case insensitivity
        romanNumber = romanNumber.toUpperCase();

        //Initial variables. romanLetters is mapped to romanValues.
        String[] romanLetters = {"I", "V", "X", "L", "C", "D", "M"};
        short[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
        short totalValue = 0;
        short previousIndex = 0;
        short sameValueCounter = 0;

        //Reading the Roman numeral from right to left
        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            char c = romanNumber.charAt(i);
            short index = findIndex(c, romanLetters);

            //If we get -1 from our findIndex method
            if (index == -1) {
                throw new RomanException(c + " is an invalid character!");
            }

            short value = romanValues[index];

            //Counting how many times the same letter has been repeated
            if (previousIndex == index || i == romanNumber.length() - 1) {
                sameValueCounter++;
            }
            else {
                sameValueCounter = 1;
            }

            /**If a letter has been repeated 4 times and it is not the highest value letter
             * i.e. M in standard Roman numeral format, then we have an exception
             */
            if (sameValueCounter == 4 && index != romanLetters.length -1) {
                throw new RomanException ("You entered " + romanNumber + " You cannot have 4 " + c + " in a row");
            }

            /**Determining whether to add or subtract.
             * For example, if we have VIII, reading from right to left we will add up I (1) 3 times and V (5) once.
             * If we have, IIIV, reading from right to left, we will start off with V (5), and subtract I (1) 3 times
             */
            if (previousIndex <= index) {
                totalValue += value;

            }
            else {

                totalValue -= value;
            }

            previousIndex = index;


        }



        return totalValue;
    }


}
