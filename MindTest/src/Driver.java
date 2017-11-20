import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {
        char[] target = "helloworld".toCharArray();
        Perceptron[] pArray = new Perceptron[target.length];
        for(int i = 0; i < target.length; i ++){
            pArray[i] = new Perceptron(target[i]);
        }

        char[] guess = new char[pArray.length];

        for(int i = 0; i < pArray.length; i ++){
            guess[i] = pArray[i].chars[pArray[i].findGreatestIndex() + 1];
            //System.out.print(guess[i]);
        }
        boolean errorFlag = true;
        int gen = 0;
        while(errorFlag){
            System.out.println("Gen: " + gen++ + "\n----------");
            for(int i = 0; i < pArray.length; i ++){
                pArray[i].adjustWeights();
            }
            guess = changeGuess(pArray, guess);
            for(int i = 0; i < pArray.length; i ++){
                System.out.print(guess[i]);
            }
            System.out.println("\n");
            if(Arrays.equals(guess, target)){
                errorFlag = false;
            }
        }
    }

    public static char[] changeGuess(Perceptron[] pArray, char[] guess){
        for(int i = 0; i < pArray.length; i ++){
            guess[i] = pArray[i].chars[pArray[i].findGreatestIndex()];
        }
        return guess;
    }
}
