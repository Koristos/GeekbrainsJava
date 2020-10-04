import java.util.Random;
import java.util.Scanner;

public class LessonThree {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);

        boolean goOn = true;
        do {
            int tryCount = 3;
            int playerAnswer = 777;
            boolean isPlayerWinner = false;
            int numberToGuess = rnd.nextInt(10);
            System.out.println("Угадай число от 0 до 9. Осталось попыток: " + tryCount);

            do {
                playerAnswer = PlayerInput();
                isPlayerWinner = CompareAnswers(playerAnswer, numberToGuess);
                if (isPlayerWinner == false) {
                    tryCount--;
                    System.out.println("Попробуй еще раз. Попыток осталось: " +tryCount);
                }
            } while (isPlayerWinner == false && tryCount > 0);
            if (tryCount <= 0) System.out.println("Ты проиграл! Правильный ответ: " + numberToGuess);
            if (isPlayerWinner == true) System.out.println("Поздравляю! Ты угадал правильно!");
            goOn=AnotherGame();
        }while (goOn==true);

        System.out.println("Теперь сыграем в угадайку. Я загадал животное, а ты попробуй отгадать.");
        String[] animalList=new String[] {"корова","лошадь","кошка","собака","слон","медведь","мамонт","копибара","антилопа","суслик"};
        boolean isWordGuessed=false;
        int wordIndex=rnd.nextInt(animalList.length);
        char[] guessedWord = WordToChar(animalList[wordIndex]);
        char[] playerWord;
        do {
            playerWord = WordToChar(scan.nextLine());
            isWordGuessed=CompareWords(guessedWord, playerWord);
            if (isWordGuessed==true) System.out.println("Поздравляю! Ты угадал!");
            else System.out.println("Попробуй еще раз!");
        }while (isWordGuessed==false);


    }


static int PlayerInput(){
        Scanner scan = new Scanner(System.in);
        boolean isNum=false;
        int playerNum=0;
        do {
            System.out.println("Введи целое число.");
            if (isNum = scan.hasNextInt()){
                playerNum=scan.nextInt();
            }else {
                String scanResult=scan.nextLine();
            }
        }while (isNum==false);
        return playerNum;

}

static boolean CompareAnswers(int playerNum, int realNum){
        if (playerNum<realNum){
            System.out.println("Загаданное число больше твоего!");
            return false;
        }else if (playerNum>realNum){
            System.out.println("Загаданное число меньше твоего!");
            return false;
        }else return true;
}

static boolean AnotherGame(){
        System.out.println("Хочешь сыграть еще раз? 1-Да / 2-Нет");
        int isYes=PlayerInput();
        if (isYes==1) return true;
        else return false;
    }

    static char[] WordToChar(String inputWord){
        char[] wordInChars=new char[15];
        for (int i=0; i<wordInChars.length;i++){
            if (i<inputWord.length()) {
                wordInChars[i] = inputWord.charAt(i);
            }else wordInChars[i]='#';
        }
        return wordInChars;
    }

    static boolean CompareWords (char guessedWord[], char playerWord[]){
        String wordToPrint="";
        boolean isItSame=true;
        for (int i=0; i<guessedWord.length;i++){
            if (guessedWord[i]==playerWord[i]){
                wordToPrint+=guessedWord[i];
            }else {
                wordToPrint+="#";
                isItSame=false;
            }
        }
        System.out.println(wordToPrint);
        return isItSame;
    }

}

