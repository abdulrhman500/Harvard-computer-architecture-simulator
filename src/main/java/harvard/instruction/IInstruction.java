package harvard.instruction;

import harvard.storage.Register;

public abstract class IInstruction implements Instruction {
    Register register1 = null;
    Byte result, immediate = null;

    public IInstruction(Register register1, Byte immediate) {
        this.register1 = register1;
        this.immediate = immediate;
    }

    public abstract void doOperation();

    public abstract Byte getResult();

    public abstract void updateFlags(int result);

    public abstract void setRegisters(Register register1, Byte immediate);
}