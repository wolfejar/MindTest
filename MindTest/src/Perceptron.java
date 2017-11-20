import java.text.DecimalFormat;
import java.util.Random;

public class Perceptron {
    Random r = new Random();
    private  char target;
    public char[] chars = getChars();
    private double[] weights = getWeights();
    private int guess = r.nextInt(200);
    public Perceptron(char c){
        target = c;
    }

    public static char[] getChars(){
        char[] chars = new char[127 - 32];
        for(int i = 32; i < 127; i ++){
            chars[i-32] = (char)i;
        }
        return chars;
    }

    public double[] getWeights(){
        Random r = new Random();
        double[] dbArray = new double[this.chars.length];
        for(int i = 0; i < this.chars.length; i ++){
            dbArray[i] = r.nextInt(100)/10.0d;
            //System.out.print(dbArray[i] + ", ");
        }
        return dbArray;
    }

    public void adjustWeights(){
        for(int i = 0; i < this.weights.length; i ++){
            int error = this.target - this.chars[i];
            if(this.chars[i] > this.target){
                    this.weights[i] = this.weights[i] - 0.05 * -error;
            }
            else if(this.chars[i] < this.target){
                    this.weights[i] = this.weights[i] + 0.05 * -error;
            }
            //System.out.print(String.format("%.2f", this.weights[i]) + ", " + this.chars[i] + ", ");
        }
        //System.out.println();
    }

    public int findGreatestIndex(){
        int greatest = 0;
        for(int i = 0; i < this.weights.length; i ++){
            if(this.weights[i] > greatest){
                greatest = i;
            }
        }
        return greatest;
    }
}
