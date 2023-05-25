package harvard.instruction;

import harvard.memory.DataMemory;
import harvard.storage.Register;

public class LB extends IInstruction {


    public LB(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {
        register1 = (DataMemory.getInstance().readAddress(immediate));
    }


    @Override
    public void updateFlags(int result) {

    }
}
