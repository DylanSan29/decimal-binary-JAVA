import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    private static final int DIVIDER = 2;
    private static final int MAX_POSITION = 16;
    public static int[] binaryNumber = new int[MAX_POSITION];
    public static int currentPosition;
    public static void main(String[] args) {
        int number;
        int out = 0;
        do{
            currentPosition = 0;
            System.out.print("Give me a number:");
            number = sc.nextInt();
            convertToBinary(number);
            System.out.println("Want to finish? ");
            out = sc.nextInt();
        }while(out == 0);
    }
    private static void convertToBinary(int number) {
        if(number>0){
            int result = number % DIVIDER;
            if(currentPosition == 0){
                binaryNumber[currentPosition] = result;
                currentPosition ++;
            }else{
                int i = 0,j = 0;
                j = currentPosition;
                do{
                    binaryNumber[j] = binaryNumber[j-1];
                    j--;
                    i++;
                }while(i<currentPosition);
                binaryNumber[0] = result;
                currentPosition ++;
            }
            number /= DIVIDER;
            convertToBinary(number);
        }else{
            for (int i = 0; i < currentPosition; i++) {
                if(i%4==0 && i!=0)
                    System.out.print(" ");
                System.out.print(binaryNumber[i]);
            }
            System.out.println();
        }
    }
}