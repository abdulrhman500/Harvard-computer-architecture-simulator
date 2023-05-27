package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;

public abstract class RInstruction implements Instruction{
    Register register1 = null, register2 = null;
    String reg1;
    Byte result = null;
    RInstruction(String register1 , String register2){
        this.reg1 = register1;
        this.register1= RegisterFile.getInstance().getRegister(register1);
        this.register2= RegisterFile.getInstance().getRegister(register2);
    }
    abstract void doOperation();

    abstract void setOperation();

    abstract void updateFlags();
}