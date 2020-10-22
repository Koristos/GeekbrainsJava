
public class DotGame {
    public static GameField newGameField;
    private static int[]playerToMove=new int[]{-1,-1};
    private static int fieldSize =3;
    private static int[][] cellValue;
    private static int[][] gameField;
    private static int inversion=1;
    public static volatile boolean goOn;
    private static int playerTurn=1;

    public static void main(String[] args) {
        int newGame = 1;

        do {
            new NewGame();
            newGameField= new GameField(fieldSize);
            gameField = NewGameField(fieldSize);
            cellValue = GiveStartValue(new int[fieldSize][fieldSize]);

            String gameOverMessage = "Ничья! Хочешь сыграть еще раз?";


            for (int i = 0; i < fieldSize * fieldSize; i++) {
                if (playerTurn == 1) PlayerMove();
                else ComputerMove();

                if (WinCheck(gameField)) {
                    gameOverMessage = (playerTurn == 1) ? "Поздравляю! Ты победил! Хочешь сыграть еще раз?" : "Я выиграл! В следующий раз старайся лучше! \n Хочешь сыграть еще раз?";
                    break;
                }
                playerTurn = (playerTurn == 1) ? 0 : 1;
            }


            new GameOver(gameOverMessage);

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


    static void PlayerMove(){
        boolean possibleMove = true;
        int x=-1;
        int y=-1;
        newGameField.CompSay(1);
        goOn=false;
        while (goOn==false){
            try{
                Thread.sleep(200);
            }catch (InterruptedException e) {
                e.printStackTrace();
            } ;
        }

            do {
                y = playerToMove[1];
                x = playerToMove[0];
                possibleMove = IsCellEmtty(y, x);
                if (possibleMove == false) newGameField.CompSay(2);
            } while (possibleMove == false);
            gameField[x][y] = -1;
            ChangeCellValue(x, y, -1);
            newGameField.Imcha(x,y,-1*inversion);

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
        newGameField.Imcha(y,x,1*inversion);

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

    public static void SetMove(int[] move){
        playerToMove=move;
    }

    public static void SetTurn(int turn){
        if (turn==0){
            inversion=1;
            playerTurn=1;
        }else if(turn==1){
            inversion=-1;
            playerTurn=0;
        }
    }

}
