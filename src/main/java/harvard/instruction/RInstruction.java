package harvard.instruction;

import harvard.storage.Register;

public abstract class RInstruction implements Instruction{
    Register register1 = null, register2 = null;
    Byte result = null;
    RInstruction(Register register1 , Register register2){
        this.register1=register1;
        this.register2= register2;
    }
    abstract void doOperation();

    abstract Byte getResult();

    abstract void updateFlags(int result);

    abstract void setRegisters(Register register1, Register register2);
}