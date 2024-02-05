package LogicGates;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 

public class LogicGatesSimIteration3 {
    static boolean[][] bbholes = new boolean[4][10];

    public static void main(String[] args) {
        System.out.println("Insert boolean values: true->HIGH or false->LOW");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            System.out.print("Enter boolean value for input " + i + ": ");
            bbholes[0][i] = scanner.nextBoolean();
        }
        scanner.close();
   
        try {
            File circuit = new File("src/circuit.txt");
            Scanner inputCircuit = new Scanner(circuit);
            System.out.println("The configuration of the circuit is :");
            System.out.println("Breadboard Inputs: ");
            for (int i = 0; i < 6; i++) {
                System.out.println("The boolean value for input " + i + "is : " + bbholes[0][i] );
               
            }
            
            while (inputCircuit.hasNextLine()) {
                String gate = inputCircuit.next();
                int input1x = inputCircuit.nextInt();
                int input1y = inputCircuit.nextInt();
                int input2x=inputCircuit.nextInt();
                int input2y=inputCircuit.nextInt();
                int outputColumn = inputCircuit.nextInt();
                int outputRow = inputCircuit.nextInt(); 
                
                switch (gate) {
                    case "AND":
                        AND and1 = new AND(input1x, input1y, input2x,input2y );
                        System.out.println("Gate :" + gate + " Input Coordinates are Row "+ input1x + " Column " + input1y  );
                        and1.calcOutput(bbholes, outputRow,outputColumn); 
                        break;
                    case "NOR":
                        NOR nor1 = new NOR(input1x, input1y, input2x,input2y);
                        System.out.println("Gate :" + gate + " Input Coordinates are Row "+ input1x + " Column " + input1y  );

                        nor1.calcOutput(bbholes,outputRow,outputColumn);
                        
                        break;
                    case "OR":
                        OR or = new OR (input1x, input1y, input2x,input2y);
                        System.out.println("Gate :" + gate + " Input Coordinates are Row "+ input1x + " Column " + input1y  );

                        or.calcOutput(bbholes,outputRow,outputColumn);
                        
                        break;
                    case "XOR":
                        XOR xor1 = new XOR(input1x, input1y, input2x,input2y);
                        System.out.println("Gate :" + gate + " Input Coordinates are Row "+ input1x + " Column " + input1y  );

                        xor1.calcOutput(bbholes,outputRow,outputColumn);
                }
          
            }
            inputCircuit.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


     
    
