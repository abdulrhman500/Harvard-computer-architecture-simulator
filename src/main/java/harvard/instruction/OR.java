package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class OR extends RInstruction {
    public OR(String register1, String register2) {
        super(register1, register2);
    }

    @Override
    void doOperation() {
        int tmp1 = register1.getData();
        int tmp2 = register2.getData();
        int tmpResult = tmp1 | tmp2;
        result = (byte) (tmpResult & EIGHT_ONES_MASK);
    }

    @Override
    public void setOperation() {
        RegisterFile.getInstance().setRegister(reg1,result);
    }

    @Override
    public void updateFlags() {
        SREG.updateFlags(EInstuctions.OR,this.result, this.register1, this.register2);
    }

}
