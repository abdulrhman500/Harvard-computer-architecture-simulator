package harvard.instruction;

import harvard.storage.Register;

public class SB implements Instruction {
    private Register register1, register2;
    byte result;
    private InstructionType type;

    public SB() {
        // Empty constructor
    }

    public SB(Register register1, Register register2, InstructionType type) {
        setRegisters(register1, register2, type);
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
    public void setRegisters(Register register1, Register register2, InstructionType type) {
        this.register1 = register1;
        this.register2 = register2;
        this.type = type;
    }
}
