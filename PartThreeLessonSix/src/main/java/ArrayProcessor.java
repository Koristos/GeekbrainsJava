import java.util.Arrays;

public class ArrayProcessor {



    public static int[] cutLastFour(int [] incomingArray){
        int flag=-1;
        int[] outputArray;
        for (int i = 0; i < incomingArray.length; i++) {
            if (incomingArray [i]==4) flag=i;
        }
        if (flag==-1) throw new RuntimeException("Array contains no 4!!!");
        outputArray= Arrays.copyOfRange(incomingArray,(flag+1),incomingArray.length);
        return outputArray;
    }

    public static boolean findOneOrFour (int[] incomingArray){
        for (int a:incomingArray) {
            if(a==1||a==4) return true;
        }
        return false;
    }
}
