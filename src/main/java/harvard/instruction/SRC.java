package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

public class SRC extends IInstruction {


    public SRC(String register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        result = (short) ((register1.getData() >>> immediate) | (register1.getData() << (8 - immediate)));
    }

    @Override
    public void setOperation() {
        RegisterFile.getInstance().setRegister(reg1,immediate);
    }

    @Override
    public void updateFlags() {
        SREG.updateFlags(EInstuctions.SRC,this.result, this.register1, null);
    }

}
