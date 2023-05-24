package harvard.instruction;

import harvard.storage.Register;

public abstract class Instruction {
    Register register1 = null, register2 = null;
    Byte result = null;
    InstructionType type = null;

    abstract void doOperation();

    abstract Byte getResult();

    abstract void updateFlags(int result);

    abstract void setRegisters(Register register1, Register register2, InstructionType type);
}