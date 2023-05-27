package harvard.instruction;

import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.memory.RegisterFile;
import harvard.storage.Register;

public abstract class IInstruction implements Instruction{
    Register register1 = null;
    String reg1;
    Short result;
    Byte immediate = null;
  public   IInstruction(String register1 ,Byte immediate){
      this.reg1 = register1;
        this.register1= RegisterFile.getInstance().getRegister(register1);
        this.immediate = immediate;
    }
    abstract void doOperation();

    abstract void setOperation() throws IncorrectMemoryAddressException;

    abstract void updateFlags();

}