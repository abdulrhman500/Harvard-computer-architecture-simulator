package harvard.instruction;

import harvard.storage.Register;

public abstract class RInstruction implements Instruction {
    private int op1, op2, destReg;

    RInstruction(int op1, int op2, int destReg) {
        this.op1 = op1;
        this.op2 = op2;
        this.destReg = destReg;
    }

    public abstract void doOperation();


    public abstract void updateFlags(int result);

    public int getOp1() {
        return op1;
    }

    public int getOp2() {
        return op2;
    }

    public int getDestReg() {
        return destReg;
    }



    public void setDestReg(int destReg) {
        this.destReg = destReg;
    }

}