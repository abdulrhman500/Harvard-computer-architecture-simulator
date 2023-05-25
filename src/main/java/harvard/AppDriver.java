package harvard;

import harvard.constants.Constants;
import harvard.instruction.*;
import harvard.memory.InstructionMemory;
import harvard.memory.RegisterFile;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

public class AppDriver {
    private int clock;
    private short FETCH = -1;
    private short DECODE = -1;
    private Instruction EXECUTE = null;

    private boolean isBranch = false;

    private void init() {
        clock = 1;
        SREG.getInstance().setData((byte) 0);

    }

    public short fetch() {
        ProgramCounter PC = ProgramCounter.getInstance();
        int pc = PC.getData();
        if (pc < 0 || pc >= InstructionMemory.getInstance().getCurrentIntruction())
            return -1;

        short curInstruction = InstructionMemory.getInstance().getInstruction(pc);
        PC.setData((byte) (pc + 1));

        return curInstruction;
    }

    public Instruction decode(short curInstruction) {
        if (curInstruction == -1) {
            return null;
        }

        DECODE = FETCH;
        int opCode = getOpCode(curInstruction);
        int r1 = getR1(curInstruction);
        int r2 = getR2(curInstruction);

        if (opCode <= 2 || opCode == 5 || opCode == 6 || opCode == 7) {
            return getRInstructionFromOpCode(opCode, r1, r2);
        } else {
            byte immValue = (byte) r2;
            return getIInstructionFromOpCode(opCode, r1, immValue);
        }
    }

    public void runNext() {
        if (isBranch) {
            isBranch = false;
            FETCH = -1;
            DECODE = -1;
            EXECUTE = null;
        }
        EXECUTE = decode(DECODE);
        DECODE = FETCH;
        FETCH = fetch();

        if (FETCH == -1 && DECODE == -1 && EXECUTE == null) {
            System.out.println("FINISHED EXECUTION");
            // TODO: print all.
            clock = 1;
            return;
        } else {
            clock++;
        }

        System.out.println("Start of Clock Cycle " + (clock - 1));
        System.out.println("Program Counter: " + (ProgramCounter.getInstance().getData() - 1));

        if (FETCH != -1) {
            System.out.println("current Fetched Instruction: " + FETCH);
        } else {
            System.out.println("No Fetch Instruction");
        }

        if (DECODE != -1) {
            System.out.println("current Decoded Instruction: " + DECODE);
        } else {
            System.out.println("No Decode Instruction");
        }

        if (EXECUTE != null) {
            System.out.println("current Executed Instruction: " + EXECUTE);
        } else {
            System.out.println("No Execute Instruction");
        }

    }

    public void execute() {
        if (EXECUTE == null) {
            return;
        }
        EXECUTE.doOperation();
    }

    private int getRangeFromBinaryNumber(int binNum, int i, int j) {
        int mask = ((1 << j) - 1) & ~((1 << i) - 1);
        return (binNum & mask) >> i;
    }

    private int getOpCode(short curInstruction) {
        return getRangeFromBinaryNumber(curInstruction, 12, 15);
    }

    private int getR1(short curInstruction) {
        return getRangeFromBinaryNumber(curInstruction, 6, 11);
    }

    private int getR2(short curInstruction) {
        return getRangeFromBinaryNumber(curInstruction, 0, 5);
    }


    private Instruction getRInstructionFromOpCode(int opCode, int r1, int r2) {
        switch (opCode) {
            case 0:
                return new ADD(RegisterFile.getInstance().getRegister(r1), RegisterFile.getInstance().getRegister(r2));
            case 1:
                return new SUB(RegisterFile.getInstance().getRegister(r1), RegisterFile.getInstance().getRegister(r2));
            case 2:
                return new Multiply(RegisterFile.getInstance().getRegister(r1), RegisterFile.getInstance().getRegister(r2));
            case 5:
                return new AND(RegisterFile.getInstance().getRegister(r1), RegisterFile.getInstance().getRegister(r2));
            case 6:
                return new OR(RegisterFile.getInstance().getRegister(r1), RegisterFile.getInstance().getRegister(r2));
            case 7:
                return new JR(RegisterFile.getInstance().getRegister(r1), RegisterFile.getInstance().getRegister(r2));
            default:
                throw new IllegalStateException("Unexpected value: " + opCode);
        }
    }

    private Instruction getIInstructionFromOpCode(int opCode, int r1, byte immValue) {
        switch (opCode) {
            case 3:
                return new LDI(RegisterFile.getInstance().getRegister(r1), immValue);
            case 4:
                return new BEQZ(RegisterFile.getInstance().getRegister(r1), immValue);
            case 8:
                return new SLC(RegisterFile.getInstance().getRegister(r1), immValue);
            case 9:
                return new SRC(RegisterFile.getInstance().getRegister(r1), immValue);
            case 10:
                return new LB(RegisterFile.getInstance().getRegister(r1), immValue);
            case 11:
                return new SB(RegisterFile.getInstance().getRegister(r1), immValue);
            default:
                throw new IllegalStateException("Unexpected value: " + opCode);
        }
    }

    public void run(String path) {
        this.init();
        // parser
        // load to memory
        // for (int inst : program )
        //fetch(this);
        //decode()
        //execute()
        //print(CLOCK)
        //increment


    }

    public static void main(String args[]) {
        AppDriver app = new AppDriver();
        app.run("");
//        Parser parser = new Parser();
//        int pc;

//       Fetch.fetch(pc);
//        this.init();
        app.run("");
        Register r1 = new Register((byte) 5);
        Register r2 = new Register((byte) -8);

//        ADD add= new ADD(r1,r2);
//        add.doOperation();
//        System.out.println(add.getResult());


    }
}