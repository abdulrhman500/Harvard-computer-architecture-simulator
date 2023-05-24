package harvard.instruction;

import harvard.storage.Register;

public class SRC extends IInstruction {


    public SRC(Register register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        // Implementation specific to SLC instruction
    }

    @Override
    public Byte getResult() {
        // Implementation specific to SLC instruction
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
