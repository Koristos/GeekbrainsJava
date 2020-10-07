import java.util.InputMismatchException;
import java.util.Scanner;

public class LessonFour {
    public static char computerDot;
    public static char playerDot;
    public static char emptyDot = '•';
    public static int[][] cellValue;
    public static int[][] gameField;

    public static void main(String[] args) {
        int fieldSize = 3;
        int newGame = 1;
        int playerTurn;


        String greetingMessage = "Поиграем в крестики-нолики? \n Выбери свой знак: 'X' - 1, 'O' - 2";


        do {
            gameField = NewGameField(fieldSize);
            cellValue = GiveStartValue(new int[fieldSize][fieldSize]);
            String gameOverMessage = "Ничья! \n Хочешь сыграть еще раз? 1 - Да, 2 - Нет";


            int chooseDot = AskPlayer(greetingMessage);
            if (chooseDot == 1) {
                computerDot = 'O';
                playerDot = 'X';
                playerTurn = 1;
            } else {
                computerDot = 'X';
                playerDot = 'O';
                playerTurn = 0;
            }

            PrintMap();

            for (int i = 0; i < fieldSize * fieldSize; i++) {
                if (playerTurn == 1) PlayerMove();
                else ComputerMove();

                if (WinCheck(gameField)) {
                    PrintMap();
                    gameOverMessage = (playerTurn == 1) ? "Поздравляю! Ты победил! \n Хочешь сыграть еще раз? 1 - Да, 2 - Нет" : "Компьютер выиграл! В следующий раз старайся лучше! \n Хочешь сыграть еще раз? 1 - Да, 2 - Нет";
                    break;
                }
                playerTurn = (playerTurn == 1) ? 0 : 1;
            }

            newGame = AskPlayer(gameOverMessage);

        } while (newGame == 1);


    }

    static int[][] NewGameField(int size) {
        int[][] emtyField = new int[size][size];
        for (int i = 0; i < emtyField.length; i++) {
            for (int b = 0; b < emtyField.length; b++) {
                emtyField[i][b] = 0;
            }
        }
        return emtyField;
    }

    static int[][] GiveStartValue(int field[][]) {
        for (int i = 0; i < field.length; i++) {
            field[i][i] += 1;
            field[i][field.length - i - 1] += 1;
        }
        return field;
    }

    static void PrintMap() {
        System.out.println(" @  1  2  3");
        for (int i = 0; i < gameField.length; i++) {
            String line = " " + (i + 1);
            for (int b = 0; b < gameField.length; b++) {
                if (gameField[i][b] == 1) line += "  " + computerDot;
                else if (gameField[i][b] == -1) line += "  " + playerDot;
                else line += "  " + emptyDot;
            }
            System.out.println(line);
        }
        System.out.println();
    }

    static int AskPlayer(String message) {
        Scanner scan = new Scanner(System.in);
        int answer = -1;
        String trash;
        System.out.println(message);
        do {
            if (scan.hasNextInt()) answer = scan.nextInt();
            else {
                trash = scan.nextLine();
                System.out.println("Нужно ввести целое число");
            }
            if (answer < 1 || answer > 2) {
                answer = -1;
                System.out.println("Нужно ввести 1 или 2");
            }
        } while (answer < 0);
        return answer;
    }

    static void PlayerMove() {
        Scanner scan = new Scanner(System.in);
        String trash;
        boolean possibleMove = true;
        int x = -1;
        int y = -1;
        boolean noExceptions=true;
        System.out.println("Ваш ход: \n Введите кординаты хода через пробел: X Y");
        do {

        try {
            noExceptions=true;
            do{
                x = scan.nextInt() - 1;
                y = scan.nextInt() - 1;
                possibleMove = IsCellEmtty(x, y);
            if (possibleMove == false) System.out.println("Эта ячейка занята. Попробуй еще раз");
        }while (possibleMove==false);
            gameField[y][x] = -1;
        } catch (InputMismatchException |ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы выели некорректные координаты. Введите координаты через пробел, не выходя за пределы игрового поля");
            trash=scan.nextLine();
            noExceptions=false;
        }
        }while (!noExceptions);
        ChangeCellValue(x, y,-1);
        PrintMap();


    }

    static void ComputerMove() {
        int x=0;
        int y=0;
        int maxValue = cellValue[0][0];
        boolean stopRotation=false;
        for (int i=0;i<gameField.length;i++){
            for (int j=0;j<gameField.length;j++){
                if(IsCellEmtty(j,i)){
                   if (TryWin(i,j)==true){
                        y=i;
                        x=j;
                        stopRotation=true;
                        break;
                    }
                }
                if (cellValue[i][j]>maxValue && IsCellEmtty(j,i)){
                    maxValue=cellValue[i][j];
                    y=i;
                    x=j;
                }
            }
            if (stopRotation)break;
        }
        gameField[y][x]=1;
        ChangeCellValue(x,y,1);
        System.out.println("Компьютер ходит на:  " +(x+1) + " " +(y+1));
        PrintMap();

    }

    static boolean IsCellEmtty(int x, int y) {
        if (gameField[y][x] != 0) return false;
        else return true;
    }

    static void ChangeCellValue(int x, int y, int value) {
        for (int n = 0; n < cellValue.length; n++) {
            cellValue[y][n] += value;
            cellValue[n][x] += value;
            cellValue[y][x] = -1000;
        }
    }

    static boolean WinCheck(int field[][]) {

        for (int i = 0; i < field.length; i++) {
            int sumX = 0;
            int sumY = 0;
            int sumDiagOne = 0;
            int sumDiagTwo = 0;
            for (int j = 0; j < field.length; j++) {
                sumY += field[i][j];
                sumX += field[j][i];
                sumDiagOne += field[j][j];
                sumDiagTwo += field[j][field.length - j - 1];

            }
            if (Math.abs(sumX) == field.length || Math.abs(sumY) == field.length || Math.abs(sumDiagOne) == field.length || Math.abs(sumDiagTwo) == field.length) return true;

        }
        return false;


    }

    static boolean TryWin (int y, int x){
        int[][]testField= new int[gameField.length][gameField.length];
        for (int i=0;i<gameField.length;i++) {
            for (int j = 0; j < gameField.length; j++) {
                testField[i][j]=gameField[i][j];
            }
        }
        boolean haveTurn=false;
        testField[y][x]=1;
        haveTurn=WinCheck(testField);
        if (!haveTurn){
            testField[y][x]=-1;
            haveTurn=WinCheck(testField);
        }
        return haveTurn;

    }
}
