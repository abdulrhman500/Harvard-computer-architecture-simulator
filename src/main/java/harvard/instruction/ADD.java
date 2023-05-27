package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class ADD extends RInstruction {

    public ADD(String r1, String r2) {
        super(r1, r2);
    }
    @Override
    public void doOperation() {
        int tmp1 = register1.getData();
        int tmp2 = register2.getData();
        int tmpResult = tmp1 + tmp2;
        result = (byte) (tmpResult & EIGHT_ONES_MASK);
        updateFlags();
    }

    @Override
    public void setOperation() {
        RegisterFile.getInstance().setRegister(reg1,result);
    }

    @Override
    void updateFlags() {
        SREG.updateFlags(EInstuctions.ADD,this.result, this.register1, this.register2);
    }


}
