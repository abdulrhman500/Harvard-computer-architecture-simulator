package harvard.instruction;

import harvard.storage.Register;

public class SB extends IInstruction {

    public SB(Register register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        // Implementation specific to SB instruction
    }

    @Override
    public Byte getResult() {
        // Implementation specific to SB instruction
        return result;
    }

    @Override
    public void updateFlags(int result) {
        // Implementation specific to SB instruction
    }

    @Override
    public void setRegisters(Register register1, Byte immediate) {
        this.register1 = register1;
        this.immediate = immediate;
    }
}
