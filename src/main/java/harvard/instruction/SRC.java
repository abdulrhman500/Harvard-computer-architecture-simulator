package harvard.instruction;

import harvard.storage.Register;
import harvard.storage.SREG;

public class SRC extends IInstruction {


    public SRC(Register register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        Byte tmpResult = (byte) ((register1.getData() >>> immediate) | (register1.getData() << (8 - immediate)));
        register1.setData(tmpResult);
    }

    @Override
    public Byte getResult() {
        boolean negative = result < 0;
        boolean zero = result == 0;
        SREG.getInstance().setNBit(negative);
        SREG.getInstance().setZBit(zero);
        return result;
    }

    @Override
    public void updateFlags(int result) {
        // Implementation specific to SLC instruction
    }

    @Override
    public void setRegisters(Register register1, Byte immediate) {
        this.register1 = register1;
        this.immediate= immediate;
    }

}
