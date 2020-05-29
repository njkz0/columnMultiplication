package actoins;

public class Actions {

    public static StringBuilder getSpaces(int spaсeQuantity) {
        StringBuilder spaces = new StringBuilder("");
        for (int i = 0; i < spaсeQuantity; i++) {
            spaces.append(" ");
        }
        return spaces;
    }

    public static StringBuilder getLines(int linesQuantity) {
        StringBuilder lines = new StringBuilder("");
        for (int i = 0; i < linesQuantity; i++) {
            lines.append("_");
        }
        return lines;
    }

    public static void columnMultiplication(int first, int second) {
        int result = first * second;
        String stringResult = Integer.toString(result);
        String stringFirst = Integer.toString(first);
        String stringSecond = Integer.toString(second);


        StringBuilder firstPartSB = new StringBuilder("");
        char[] arrayWithNumbers;
        int lastDigitInSmallerNumber;
        int greaterNumber;
        int lowerNumber;

        if (first > second) {
            greaterNumber=first;
            lowerNumber=second;
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
                firstPartSB.append(getLines(Integer.toString(lastDigitInSmallerNumber * first).length()));
            }



        } else{
            greaterNumber=second;
            lowerNumber=first;

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
                firstPartSB.append(getLines(Integer.toString(lastDigitInSmallerNumber * second).length()));
            }

        } //конец первой части выражиния
        StringBuilder secondPartSB= new StringBuilder("");
          int quantityOfActions=arrayWithNumbers.length;
          int quantityOfSpaces=stringResult.length()-(Integer.toString(greaterNumber*(arrayWithNumbers[quantityOfActions-1]-'0')).length());
          for(  int n=quantityOfActions; n>0; n--){
              secondPartSB.append(getSpaces(quantityOfSpaces));
              quantityOfSpaces--;
              secondPartSB.append(Integer.toString(greaterNumber*(arrayWithNumbers[n-1]-'0')));
              secondPartSB.append("\n");
          }

          StringBuilder thirdPartSB= new StringBuilder();
          thirdPartSB.append(getLines(stringResult.length()));
          thirdPartSB.append("\n");
          thirdPartSB.append(stringResult);

        String firstPart = firstPartSB.toString();
        String secondPart=secondPartSB.toString();
        String thirdPart=thirdPartSB.toString();
        System.out.print(String.format("%s\n%s%s", firstPart, secondPart, thirdPart));
    }
}

