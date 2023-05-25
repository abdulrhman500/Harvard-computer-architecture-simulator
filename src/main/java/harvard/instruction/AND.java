package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class AND extends RInstruction {


    public AND(int op1, int op2, int destReg) {
        super(op1, op2, destReg);
    }

    @Override
    public void doOperation() {
        int tmpResult = getOp1() & getOp2();
        byte result = (byte) (tmpResult & EIGHT_ONES_MASK);
        RegisterFile.getInstance().setRegister(getDestReg(), result);
        updateFlags(tmpResult);
    }

    @Override
    public void updateFlags(int result) {
        boolean negative = result < 0;
        boolean zero = result == 0;
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setZBit(zero);
    }

}
