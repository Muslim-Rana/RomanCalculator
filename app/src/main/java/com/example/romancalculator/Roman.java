package com.example.romancalculator;

public class Roman {

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
        }



        return 1; //temporary testing value
    }
}
