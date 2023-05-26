package harvard;

import harvard.constants.Constants;
import harvard.instruction.*;
import harvard.memory.InstructionMemory;
import harvard.memory.RegisterFile;
import harvard.operation.ALU;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;

public class AppDriver {
    private int clock;
    private short FETCH = -1;
    private short DECODE = -1;
    private short EXECUTE = -1;

    private boolean isBranch = false;

    private void init() {
        clock = 1;
        SREG.getInstance().setData((byte) 0);

    }

    public short fetch() {
        int pc = RegisterFile.getInstance().getPC();
        if (pc < 0 || pc >= InstructionMemory.getInstance().getCurrentIntruction())
            return -1;

        short curInstruction = InstructionMemory.getInstance().getInstruction(pc);
        RegisterFile.getInstance().setPC((byte) (pc + 1));

        return curInstruction;
    }

    public void decode(short curInstruction) {
        if (curInstruction == -1) {
            return;
        }

        DECODE = FETCH;
        int opCode = getOpCode(curInstruction);
        int r1 = getR1(curInstruction);
        int r2 = getR2(curInstruction);

        ALU.getInstance().setOpCode(opCode);
        ALU.getInstance().setOperand1(r1);
        ALU.getInstance().setOperand2(r2);

    }

    public void runNext() {
        if (isBranch) {
            isBranch = false;
            FETCH = -1;
            DECODE = -1;
            EXECUTE = -1;
        }
        EXECUTE = DECODE;
        DECODE = FETCH;
        FETCH = fetch();

        if (FETCH == -1 && DECODE == -1 && EXECUTE == -1) {
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

        if (EXECUTE != -1) {
            System.out.println("current Executed Instruction: " + EXECUTE);
            ALU.getInstance().execute();
        } else {
            System.out.println("No Execute Instruction");
        }

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