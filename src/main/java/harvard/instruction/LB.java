package harvard.instruction;

import harvard.memory.DataMemory;
import harvard.memory.RegisterFile;
import harvard.storage.Register;

public class LB extends IInstruction {


    public LB(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {
        register1 = (DataMemory.getInstance().readAddress(immediate));
        //TODO: write in the dist reg
    }


    @Override
    public void updateFlags(int result) {
        RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.LB, result, (byte) getRegister1(), null);
    }
}
