package harvard.instruction;

import harvard.storage.Register;
import harvard.storage.SREG;

public class SLC extends IInstruction {


    public SLC(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {
        Byte tmpResult = (byte) ((register1 << immediate) | (register1 >>> (8 - immediate)));
        register1 = tmpResult;
    }

    @Override
    public void updateFlags(int result) {
        boolean negative = result < 0;
        boolean zero = result == 0;
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setZBit(zero);
    }

}
