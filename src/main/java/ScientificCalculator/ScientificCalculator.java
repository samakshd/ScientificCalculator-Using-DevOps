package ScientificCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class ScientificCalculator {
    private static final Logger logger = LogManager.getLogger(ScientificCalculator.class);
    public static void main(String[] args) {

        ScientificCalculator calculator = new ScientificCalculator();
        Scanner scanner = new Scanner(System.in);

        // When the Docker container is started in the background via Ansible and you attach your terminal to it,
        // the initial application System.out.println statements are wiped out, to avoid that we use this stop-gap fix
        // Only enter the application once the user has pressed Enter key on the terminal.
        System.out.println("Press Enter key to start the application\n");
        scanner.nextLine();

        Boolean exit = false;
        while(!exit) {
            System.out.println("---------------------");
            System.out.println("Scientific Calculator");
            System.out.println("---------------------");
            System.out.println("");
            System.out.println("Operations Menu");
            System.out.println("");
            System.out.println("1) Square Root");
            System.out.println("2) Factorial");
            System.out.println("3) Natural Logarithm");
            System.out.println("4) Power");
            System.out.println("5) Exit\n");

            int operation_id = -1;
            Boolean validOperationID = false;
            while(!validOperationID) {
                System.out.print("Enter Operation ID: ");
                try {
                    operation_id = scanner.nextInt();

                    if(operation_id != 1 && operation_id != 2 && operation_id != 3 && operation_id != 4 && operation_id != 5) {
                        throw new InputMismatchException();
                    }
                    validOperationID=true;
                }
                catch (InputMismatchException error) {
                    System.out.println(operation_id);
                    System.out.println("Error: Invalid Operation ID");
                    scanner.nextLine();
                }
            }


            if(operation_id == 1) {
                Boolean validInput = false;
                double number=-1;
                while(!validInput) {
                    System.out.print("Enter a number: ");

                    try{
                        number = scanner.nextDouble();
                        validInput=true;
                    }
                    catch(InputMismatchException error) {
                        System.out.println("Error: Invalid Input");
                        scanner.nextLine();
                    }
                }
                double result = calculator.squareRoot(number);
                System.out.println("Square Root of " + number + " = " + result);
            }
            else if(operation_id == 2) {
                Boolean validInput = false;
                int number=-1;
                while(!validInput) {
                    System.out.print("Enter an Integer Number: ");

                    try{
                        number = scanner.nextInt();
                        validInput=true;
                    }
                    catch(InputMismatchException error) {
                        System.out.println("Error: Invalid Input");
                        scanner.nextLine();
                    }
                }
                double result = calculator.factorial(number);
                System.out.println("Factorial of " + number + " = " + result);
            }
            else if(operation_id == 3) {
                Boolean validInput = false;
                double number=-1;
                while(!validInput) {
                    System.out.print("Enter a number: ");

                    try{
                        number = scanner.nextDouble();
                        validInput=true;
                    }
                    catch(InputMismatchException error) {
                        System.out.println("Error: Invalid Input");
                        scanner.nextLine();
                    }
                }
                double result = calculator.naturalLog(number);
                System.out.println("Natural Log of " + number + " = " + result);
            }
            else if(operation_id == 4) {
                Boolean validInput1 = false;
                double number1=-1;
                while(!validInput1) {
                    System.out.print("Enter the base number: ");
                    try{
                        number1 = scanner.nextDouble();
                        validInput1=true;
                    }
                    catch(InputMismatchException error) {
                        System.out.println("Error: Invalid Input");
                        scanner.nextLine();
                    }
                }

                Boolean validInput2 = false;
                double number2=-1;
                while(!validInput2) {
                    System.out.print("Enter the base number: ");
                    try{
                        number2 = scanner.nextDouble();
                        validInput2=true;
                    }
                    catch(InputMismatchException error) {
                        System.out.println("Error: Invalid Input");
                        scanner.nextLine();
                    }
                }


                double result = calculator.power(number1,number2);
                System.out.println("Power of " + number1 + " raise to " + number2 + " = " + result);
            }
            else if(operation_id == 5) {
                System.out.println("Exiting the Application............");
                break;
            }

        }

        scanner.close();
    }

    public double squareRoot(double number) {
        double result = 0;
        try {
            if(number < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Square Root of Negative Numbers is Irrational");
            }

            result = Math.sqrt(number);
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - SQUARE ROOT]: "+error.getLocalizedMessage());
        }

        logger.info("[SQUARE_ROOT] - " + number + " - [RESULT] - " + result);
        return result;
    }

    public double factorial(int number) {
        double result = 1;
        try{
            if(number<0) {
                result = Double.NaN;
                throw new ArithmeticException("Factorial of negative number is not possible");
            }
            else {
                for(int i = 1; i <= number; i++)
                    result *= i;
            }
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - FACTORIAL]: "+error.getLocalizedMessage());
        }

        logger.info("[FACTORIAL] - " + number + " - [RESULT] - " + result);
        return result;
    }


    public double naturalLog(double number) {
        double result = 0;

        try {
            if(number <= 0) {
                result = Double.NaN;
                throw new ArithmeticException("Cannot find log of non-positive numbers");
            }
            else
                result = Math.log(number);
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - NATURAL LOG]: " + error.getLocalizedMessage());
        }
        logger.info("[LOGARITHM] - " + number + " - [RESULT] - " + result);
        return result;
    }

    public double power(double number1, double number2) {
        double result = 0;
        try{
            if(number1 == 0 && number2 ==0) {
                result = Double.NaN;
                throw new ArithmeticException("Pow(0,0) is not defined");
            }

            result = Math.pow(number1,number2);

        }
        catch(ArithmeticException error) {
            System.out.println("[EXCEPTION - POWER]: " + error.getLocalizedMessage());
        }

        logger.info("[POWER] - " + number1 + " " + number2 + " - [RESULT] - " + result);
        return result;
    }

}

