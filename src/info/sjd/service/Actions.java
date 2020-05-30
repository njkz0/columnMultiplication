package info.sjd.service;

public class Actions {

    public static StringBuilder getSpaces(int spaceQuantity) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < spaceQuantity; i++) {
            spaces.append(" ");
        }
        return spaces;
    }

    public static StringBuilder getLines(int linesQuantity) {
        StringBuilder lines = new StringBuilder();
        for (int i = 0; i < linesQuantity; i++) {
            lines.append("_");
        }
        return lines;
    }

    public static String columnMultiplication(int first, int second) {
        int result = first * second;
        String stringResult = Integer.toString(result);
        String stringFirst = Integer.toString(first);
        String stringSecond = Integer.toString(second);


        StringBuilder firstPartSB = new StringBuilder();
        char[] arrayWithNumbers;
        int lastDigitInSmallerNumber;
        int greaterNumber;
        int lowerNumber;

        if (first > second) {
            greaterNumber=first;
            arrayWithNumbers = stringSecond.toCharArray();
            lastDigitInSmallerNumber = (arrayWithNumbers[arrayWithNumbers.length - 1]) - '0';

            firstPartSB.append(getSpaces(stringResult.length() - stringFirst.length()));
            firstPartSB.append(first);
            firstPartSB.append("\n");
            firstPartSB.append(getSpaces(stringResult.length() - stringSecond.length()));
            firstPartSB.append(second);
            firstPartSB.append("\n");

            if (stringFirst.length() >= Integer.toString(lastDigitInSmallerNumber * first).length()) {
                firstPartSB.append(getSpaces(stringResult.length() - stringFirst.length()));
                firstPartSB.append(getLines(stringFirst.length()));
            } else{
                firstPartSB.append(getSpaces(stringResult.length() - Integer.toString(lastDigitInSmallerNumber * first).length()));
                firstPartSB.append(getLines(lastDigitInSmallerNumber * first).length());
            }



        } else{
            greaterNumber=second;
            arrayWithNumbers = stringFirst.toCharArray();
            lastDigitInSmallerNumber = (arrayWithNumbers[arrayWithNumbers.length - 1]) - '0';

            firstPartSB.append(getSpaces(stringResult.length() - stringSecond.length()));
            firstPartSB.append(second);
            firstPartSB.append("\n");
            firstPartSB.append(getSpaces(stringResult.length() - stringFirst.length()));
            firstPartSB.append(first);
            firstPartSB.append("\n");

            if (stringSecond.length() >= Integer.toString(lastDigitInSmallerNumber * second).length()) {
                firstPartSB.append(getSpaces(stringResult.length() - stringSecond.length()));
                firstPartSB.append(getLines(stringSecond.length()));
            } else{
                firstPartSB.append(getSpaces(stringResult.length() - Integer.toString(lastDigitInSmallerNumber * second).length()));
                firstPartSB.append(getLines(lastDigitInSmallerNumber * second).length());
            }

        } //end of the first part
        StringBuilder secondPartSB= new StringBuilder();
          int quantityOfActions=arrayWithNumbers.length;
          int quantityOfSpaces=stringResult.length()-(Integer.toString(greaterNumber*(arrayWithNumbers[quantityOfActions-1]-'0')).length());
          for(  int n=quantityOfActions; n>0; n--){
              secondPartSB.append(getSpaces(quantityOfSpaces));
              quantityOfSpaces--;
              secondPartSB.append(greaterNumber*(arrayWithNumbers[n-1]-'0'));
              secondPartSB.append("\n");
          }// end of the second part

          StringBuilder thirdPartSB= new StringBuilder();
          thirdPartSB.append(getLines(stringResult.length()));
          thirdPartSB.append("\n");
          thirdPartSB.append(stringResult);//and of the third part

        String firstPart = firstPartSB.toString();
        String secondPart=secondPartSB.toString();
        String thirdPart=thirdPartSB.toString();

        return String.format("%s\n%s%s", firstPart, secondPart, thirdPart);
    }
}

