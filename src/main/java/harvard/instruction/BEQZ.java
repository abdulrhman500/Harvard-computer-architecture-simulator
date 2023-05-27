package harvard.instruction;

import harvard.constants.Constants;
import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

public class BEQZ extends IInstruction {

    public BEQZ(String register1, Byte immediate) {
        super(register1, immediate);
    }

    @Override
    public void doOperation() {
        if (((Register)register1).getData() == 0) {
            result = (short) (RegisterFile.getInstance().getRegister(Constants.PC_NAME_REGISTER).getData() + 1 + immediate);
        }
    }

    @Override
    public void setOperation() {
        RegisterFile.getInstance().setRegister(Constants.PC_NAME_REGISTER,(byte) (result*1L));
    }


    @Override
    public void updateFlags() {
        SREG.updateFlags(EInstuctions.BEQZ,this.result, this.register1, null);
    }



}
