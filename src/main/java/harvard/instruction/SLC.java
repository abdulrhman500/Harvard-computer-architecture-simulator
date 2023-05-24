package harvard.instruction;

import harvard.storage.Register;

public class SLC implements Instruction {
    private Register register1, register2;
    byte result;
    private InstructionType type;

    public SLC() {
        // Empty constructor
    }

    public SLC(Register register1, Register register2, InstructionType type) {
        setRegisters(register1, register2, type);
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
    public void updateFlags() {
        // Implementation specific to SLC instruction
    }

    @Override
    public void setRegisters(Register register1, Register register2, InstructionType type) {
        this.register1 = register1;
        this.register2 = register2;
        this.type = type;
    }
}
