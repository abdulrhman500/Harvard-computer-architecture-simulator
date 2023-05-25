package harvard.instruction;

import harvard.storage.ProgramCounter;
import harvard.storage.Register;

public class JR extends RInstruction {

    public JR(int op1, int op2, int destReg) {
        super(op1, op2, destReg);
    }

    @Override
    public void doOperation() {

        String reg1 = Integer.toBinaryString(getOp1()).substring(28, 32);
        String reg2 = Integer.toBinaryString(getOp2()).substring(28, 32);
        String concatenation = reg1 + reg2;
        byte result = Byte.parseByte(concatenation, 2);
        ProgramCounter.getInstance().setData(result);
        //OR
//        ProgramCounter.getInstance().setData((byte)Integer.parseInt(register1.getData()+""+ register2.getData()));
    }

    @Override
    public void updateFlags(int result) {
        // Implementation specific to JR instruction
    }

}
