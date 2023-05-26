package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

public class BEQZ extends IInstruction {

    public BEQZ(int register1, int immediate, int destReg) {
        super(register1, immediate, destReg);
    }

    @Override
    public void doOperation() {

        if (register1 == 0) {
            RegisterFile.getInstance().setPC((short) (RegisterFile.getInstance().getPC() +1 +immediate));
        }
    }




    @Override
    public void updateFlags(int result) {
        RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.BEQZ, result, (byte) getRegister1(), null);
    }

}
