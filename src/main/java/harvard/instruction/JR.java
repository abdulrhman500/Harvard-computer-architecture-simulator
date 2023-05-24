package harvard.instruction;

import harvard.storage.Register;

public class JR extends RInstruction {
    private Register register1, register2;
    byte result;
    private InstructionType type;



    public JR(Register register1, Register register2) {
        super(register1, register2);
    }

    @Override
    public void doOperation() {
        // Implementation specific to JR instruction
    }

    @Override
    public Byte getResult() {
        // Implementation specific to JR instruction
        return result;
    }

    @Override
    public void updateFlags(int result) {
        // Implementation specific to JR instruction
    }

    @Override
    public void setRegisters(Register register1, Register register2) {
        this.register1 = register1;
        this.register2 = register2;
    }
}
