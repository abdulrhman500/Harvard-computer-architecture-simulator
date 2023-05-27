package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;
import harvard.storage.SREG;

import static harvard.constants.Constants.EIGHT_ONES_MASK;

public class AND extends RInstruction {


    public AND(String register1, String register2) {
        super(register1,register2);
    }

    @Override
    public void doOperation() {
        int tmp1 = ((Register)register1).getData();
        int tmp2 = ((Register)register2).getData();
        int tmpResult = tmp1 & tmp2;
        result = (byte) (tmpResult & EIGHT_ONES_MASK);
    }

    public void setOperation() {
        RegisterFile.getInstance().setRegister(reg1,result);
    }

    @Override
    public void updateFlags() {
        SREG.updateFlags(EInstuctions.AND,this.result, this.register1, this.register2);
    }


}
