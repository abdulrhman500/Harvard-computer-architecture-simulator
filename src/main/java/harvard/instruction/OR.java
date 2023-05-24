package harvard.instruction;

import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class OR extends RInstruction {
    public OR(Register register1, Register register2) {
        super(register1, register2);
    }

    @Override
    void doOperation() {
        int tmp1 = register1.getData();
        int tmp2 = register2.getData();
        int tmpResult = tmp1 | tmp2;
        result = (byte) (tmpResult & EIGHT_ONES_MASK);
        updateFlags(tmpResult);
    }

    @Override
    Byte getResult() {
        return null;
    }

    @Override
    void updateFlags(int result) {

        boolean negative = result < 0;
        boolean zero = result == 0;
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setZBit(zero);
    }

    @Override
    void setRegisters(Register register1, Register register2) {
        this.register1 = register1;
        this.register2 = register2;

    }

}
