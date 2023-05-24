package harvard.instruction;

import harvard.storage.Register;

public interface Instruction {
    Byte register1 = null, register2 = null, result = null;
    InstructionType type = null;
    void doOperation();

    Byte getResult();

    void updateFlags();

    void setRegisters(Register register1, Register register2, InstructionType type);
}
