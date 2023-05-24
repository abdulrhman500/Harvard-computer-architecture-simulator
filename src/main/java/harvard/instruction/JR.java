package harvard.instruction;

import harvard.storage.ProgramCounter;
import harvard.storage.Register;

public class JR extends RInstruction {

    public JR(Register register1, Register register2) {
        super(register1, register2);
    }

    @Override
    public void doOperation() {

        String reg1 = Integer.toBinaryString(register1.getData()).substring(28, 32);
        String reg2 = Integer.toBinaryString(register2.getData()).substring(28, 32);
        String concatenation = reg1 + reg2;
        result = Byte.parseByte(concatenation, 2);
        ProgramCounter.getInstance().setData(result);
        //OR
//        ProgramCounter.getInstance().setData((byte)Integer.parseInt(register1.getData()+""+ register2.getData()));
    }

    @Override
    public Byte getResult() {
        // Implementation specific to JR instruction
        return result;
    }

    @Override
    public void updateFlags(int result) {
        // Implementation specific to JR instruction
    }

    @Override
    public void setRegisters(Register register1, Register register2) {
        this.register1 = register1;
        this.register2 = register2;
    }
}
