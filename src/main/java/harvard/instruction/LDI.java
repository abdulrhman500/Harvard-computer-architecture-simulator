package harvard.instruction;

import harvard.constants.Constants;
import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

public class LDI extends IInstruction {

    public LDI(String register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        result = (short)(RegisterFile.getInstance().getRegister(reg1).getData());
    }


    @Override
    public void setOperation() {
        RegisterFile.getInstance().setRegister(reg1,immediate);
    }

    @Override
    public void updateFlags() {
        SREG.updateFlags(EInstuctions.LDI,this.result, this.register1, null);
    }
}
