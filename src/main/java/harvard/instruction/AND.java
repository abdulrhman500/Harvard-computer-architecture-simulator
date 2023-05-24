package harvard.instruction;

import harvard.storage.Register;

public class AND implements Instruction {
    private Register register1, register2;
    byte result;
    private InstructionType type;

    public AND() {
        // Empty constructor
    }

    public AND(Register register1, Register register2, InstructionType type) {
        setRegisters(register1, register2, type);
    }

    @Override
    public void doOperation() {
        // Implementation specific to AND instruction
    }

    @Override
    public Byte getResult() {
        // Implementation specific to AND instruction
        return result;
    }

    @Override
    public void updateFlags(int result) {
        // Implementation specific to AND instruction
    }

    @Override
    public void setRegisters(Register register1, Register register2, InstructionType type) {
        this.register1 = register1;
        this.register2 = register2;
        this.type = type;
    }
}
