package harvard.instruction;

import harvard.storage.Register;
import harvard.storage.SREG;

public class SLC extends IInstruction {


    public SLC(Register register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        Byte tmpResult = (byte) ((register1.getData() << immediate) | (register1.getData() >>> (8 - immediate)));
        register1.setData(tmpResult);
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
    public void setRegisters(Register register1, Byte immediate) {
        this.register1 = register1;
        this.immediate= immediate;
    }

}
