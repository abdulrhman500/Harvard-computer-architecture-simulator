package harvard.instruction;

import harvard.constants.Constants;
import harvard.memory.RegisterFile;
import harvard.storage.SREG;

public class JR extends RInstruction {

    public JR(String register1, String register2) {
        super(register1, register2);
    }

    @Override
    public void doOperation() {

        byte tmp1 = register1.getData();
        byte tmp2 = register2.getData();
        result = Byte.parseByte(tmp1 +"" +tmp2);
    }

    @Override
    void setOperation() {
        RegisterFile.getInstance().setRegister(Constants.PC_NAME_REGISTER,result);
    }


    @Override
    public void updateFlags() {
        SREG.updateFlags(EInstuctions.JR,this.result, this.register1, this.register2);
    }

}
