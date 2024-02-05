package LogicGates;

public class NOR {
    private int input1x;
    private int input1y;
    private int input2x;
    private int input2y;
    
    

    public NOR(int input1x, int input1y, int input2x,int input2y) {
        this.input1x = input1x;
        this.input1y = input1x;
        this.input2x = input2x;
        this.input2y = input2y;
       
    }

    public void calcOutput(boolean[][] bbholes, int outputRow,int outputColumn ) {
        boolean result =!( bbholes[input1x][input1y] || bbholes[input2x][input2y]);
        bbholes[outputRow][outputColumn] = result;
    }
}
