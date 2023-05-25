package harvard.instruction;

import harvard.storage.Register;
import harvard.storage.SREG;

public class SRC extends IInstruction {


    public SRC(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {
        Byte tmpResult = (byte) ((register1 >>> immediate) | (register1 << (8 - immediate)));
        register1 = tmpResult;
    }


    @Override
    public void updateFlags(int result) {
        // Implementation specific to SLC instruction
    }


}
