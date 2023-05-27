package harvard.instruction;

import harvard.constants.Constants;
import harvard.memory.DataMemory;
import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

public class LB extends IInstruction {


    public LB(String register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        result = (short)(DataMemory.getInstance().readAddress(immediate));
    }



    @Override
    public void setOperation() {
        RegisterFile.getInstance().setRegister(reg1,(byte)(result*1L));
    }

    @Override
    public void updateFlags() {
        SREG.updateFlags(EInstuctions.LB,this.result, this.register1, null);
    }

}
