package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.Register;

public class LDI extends IInstruction {

    public LDI(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {
        // Implementation specific to LDI instruction
    }


    @Override
    public void updateFlags(int result) {
        RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.LDI, result, (byte) getRegister1(), null);
    }

}
