package harvard.instruction;

import harvard.memory.RegisterFile;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

public class JR extends RInstruction {

    public JR(int op1, int op2, int destReg) {
        super(op1, op2, destReg);
    }

    @Override
    public void doOperation() {

         //TODO: concatenation
    }

    @Override
    public void updateFlags(int result) {
        RegisterFile.getInstance().getSREG().updateFlags(EInstuctions.JR, result, (byte) getOp1(), (byte) getOp2());
    }

}
