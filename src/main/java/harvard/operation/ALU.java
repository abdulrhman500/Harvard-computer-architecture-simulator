package harvard.operation;

import harvard.instruction.*;
import harvard.memory.RegisterFile;

public class ALU {

    private int opCode, operand1, operand2;

    private static ALU instance = null;

    public static ALU getInstance() {
        if (instance == null)
            instance = new ALU();
        return instance;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public void execute() {
        Instruction instruction = getInstruction();
    }

    private Instruction getInstruction() {
        if (opCode <= 2 || opCode == 5 || opCode == 6 || opCode == 7) {
            return getRInstructionFromOpCode(opCode, operand1, operand2);
        } else {
            byte immValue = (byte) operand2;
            return getIInstructionFromOpCode(opCode, operand1, immValue);
        }
    }

    private Instruction getRInstructionFromOpCode(int opCode, int r1, int r2) {
        switch (opCode) {
            case 0:
                return new ADD(RegisterFile.getInstance().getRegister(r1).getData(), RegisterFile.getInstance().getRegister(r2).getData(), r1);
            case 1:
                return new SUB(RegisterFile.getInstance().getRegister(r1).getData(), RegisterFile.getInstance().getRegister(r2).getData(), r1);
            case 2:
                return new Multiply(RegisterFile.getInstance().getRegister(r1).getData(), RegisterFile.getInstance().getRegister(r2).getData(), r1);
            case 5:
                return new AND(RegisterFile.getInstance().getRegister(r1).getData(), RegisterFile.getInstance().getRegister(r2).getData(), r1);
            case 6:
                return new OR(RegisterFile.getInstance().getRegister(r1).getData(), RegisterFile.getInstance().getRegister(r2).getData(), r1);
            case 7:
                return new JR(RegisterFile.getInstance().getRegister(r1).getData(), RegisterFile.getInstance().getRegister(r2).getData(), 0);
            default:
                throw new IllegalStateException("Unexpected value: " + opCode);
        }
    }

    private Instruction getIInstructionFromOpCode(int opCode, int r1, byte immValue) {
        switch (opCode) {
            case 3:
                return new LDI(RegisterFile.getInstance().getRegister(r1).getData(), immValue, r1);
            case 4:
                return new BEQZ(RegisterFile.getInstance().getRegister(r1).getData(), immValue, 0);
            case 8:
                return new SLC(RegisterFile.getInstance().getRegister(r1).getData(), immValue, r1);
            case 9:
                return new SRC(RegisterFile.getInstance().getRegister(r1).getData(), immValue, r1);
            case 10:
                return new LB(RegisterFile.getInstance().getRegister(r1).getData(), immValue, r1);
            case 11:
                return new SB(RegisterFile.getInstance().getRegister(r1).getData(), immValue, 0);
            default:
                throw new IllegalStateException("Unexpected value: " + opCode);
        }
    }
}
