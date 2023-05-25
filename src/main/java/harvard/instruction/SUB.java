package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class SUB extends RInstruction {
    public SUB(int op1, int op2, int destReg) {
        super(op1, op2, destReg);
    }

    @Override
    public void doOperation() {
        int tmpResult = getOp1() - getOp2();
        byte result = (byte) (tmpResult & EIGHT_ONES_MASK);
        RegisterFile.getInstance().setRegister(getDestReg(), result);
        updateFlags(tmpResult);
    }

    @Override
    public void updateFlags(int result) {
        boolean carry = ((result >> 8) & 1) == 1;
        boolean overflow = false;
        boolean negative = result < 0;
        boolean zero = result == 0;
        int resultSign = (result >> 7) & 1;
        int register2Sign = (getOp1() >> 7) & 1;
        if (resultSign == register2Sign)
            overflow = true;
        boolean sign = negative ^ overflow;
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setCBit(carry);
        SREG.getInstance().setVBit(overflow);
        SREG.getInstance().setZBit(zero);
        SREG.getInstance().setSBit(sign);
    }


}

