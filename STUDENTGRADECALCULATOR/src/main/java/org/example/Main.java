package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int numSub;
        int sum =0;
        char grade;
        double average =0.0;

        System.out.print("Enter the number of subjects ");
        numSub = input.nextInt();

        sum = Marks(numSub,input);
        average = (double) sum /numSub;

        grade = Grade(average);


//        System.out.println("sum !"+ sum);
//        System.out.println("average! "+ average);
//        System.out.println("grade! "+ grade);
        System.out.println("The sum of the marks :" + sum + " the average :" + average + "% the grade is :" + grade);

    }

    // Markers Method
    public static int Marks(int subject, Scanner input){
        int marks;
        int total =0;


        for (int i =1; i <=subject; i++){

            System.out.print("entre the mark "+ i + " mark : ");
            marks = input.nextInt();

            if (marks >=0 && marks <101){
                total = total + marks;

            }else {
                i=i-1;
                System.out.println("Please and a valid number for 0 to 100");
            }
        }
        return total;

    }
    //Grade Method
    public static char Grade(double average){

        if(average >=80 && 101> average){
            return 'A';
        } else if (average >=70 && 80> average) {
            return 'B';
        } else if (average >= 60 && 70> average) {
            return 'C';
        } else if (average >=50 && 60> average) {
            return 'D';
        } else if (average >=40 && 50> average) {
            return 'E';
        }else {
            return 'F';
        }
    }

}