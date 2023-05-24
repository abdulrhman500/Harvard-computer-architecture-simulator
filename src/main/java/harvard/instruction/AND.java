package harvard.instruction;

import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class AND extends Instruction {

    private InstructionType type;

    public AND() {

    }

    public AND(Register register1, Register register2, InstructionType type) {
        setRegisters(register1, register2, type);
    }

    @Override
    public void doOperation() {
        int tmp1 = register1.getData();
        int tmp2 = register2.getData();
        int tmpResult = tmp1 & tmp2;
        result = (byte) (tmpResult & EIGHT_ONES_MASK);
        updateFlags(tmpResult);
    }

    @Override
    public Byte getResult() {
        return result;
    }

    @Override
    public void updateFlags(int result) {
        boolean negative = result < 0;
        boolean zero = result == 0;
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setZBit(zero);
    }

    @Override
    public void setRegisters(Register register1, Register register2, InstructionType type) {
        this.register1 = register1;
        this.register2 = register2;
        this.type = type;
    }
}
