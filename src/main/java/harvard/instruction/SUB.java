package harvard.instruction;

import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class SUB extends RInstruction {
    public SUB(Register register1, Register register2) {
        super(register1, register2);
    }

    @Override
    public void doOperation() {
        int tmp1 = register1.getData();
        int tmp2 = register2.getData();
        int tmpResult = tmp1 - tmp2;
        result = (byte) (tmpResult & EIGHT_ONES_MASK);
        updateFlags(tmpResult);
    }

    @Override
    public Byte getResult() {
        return result;
    }
    @Override
    public void updateFlags(int result) {
        boolean carry = ((result >> 8) & 1) == 1;
        boolean overflow = false;
        boolean negative = result < 0;
        boolean zero = result == 0;
      int resultSign = (result>>7)&1;
        int register2Sign = (register1.getData() >> 7) & 1;
        if (resultSign == register2Sign)
            overflow = true;
        boolean sign = negative ^ overflow;
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setCBit(carry);
        SREG.getInstance().setVBit(overflow);
        SREG.getInstance().setZBit(zero);
        SREG.getInstance().setSBit(sign);
    }

    @Override
    public void setRegisters(Register register1, Register register2) {

    }
}

