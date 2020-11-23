public class Process {
    public void process( String inputArray[][]) throws MyArraySizeException, MyArrayDataException {
        int output = 0;
        doLengthCheck(inputArray);
        doInstanceCheck(inputArray);
            for (int i = 0; i < inputArray.length; i++) {
                for (int y = 0; y < inputArray.length; y++) {
                    output += Integer.parseInt(inputArray[i][y]);
                }
            }
        System.out.println("Сумма значений массива: "+output+".\nПроцесс завершен успешно.");
    }

    private void doLengthCheck (String[][] arrayToCheck) throws MyArraySizeException {
        boolean checkPassed=true;
        if (arrayToCheck.length!=4) checkPassed=false;
        for (int i=0;i<arrayToCheck.length;i++){
            if (arrayToCheck[i].length!=4) checkPassed=false;
        }
        if (checkPassed==false) throw new MyArraySizeException("Input array is out of bounds. Input array must have size = 4*4.");

    }

    private void doInstanceCheck (String[][] arrayToCheck) throws MyArrayDataException{
        for (int i = 0; i < arrayToCheck.length; i++) {
            for (int y = 0; y < arrayToCheck.length; y++) {
                try{
                    int a=Integer.parseInt(arrayToCheck[i][y]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Array contains data, that is not a number in cell ["+i+"]["+y+"]");
                }
            }
        }
    }

    }

