package harvard.operation;

import harvard.memory.RegisterFile;
import harvardComputerExceptions.InvalidInstructionException;
import storage.ProgramCounter;
import storage.Register;
import storage.SREG;

public class ALU {

    static ALU instance = null;
    private ALU(){

    }

    public void RegisterInstruction(Instuctions instruction , String firstRegister, String secondRegister) throws InvalidInstructionException {
        RegisterFile registerFile = RegisterFile.getInstance();
        Register R1 =  registerFile.getRegister(firstRegister);
        Register R2 =  registerFile.getRegister(firstRegister);
        switch (instruction){
        case ADD:{
            int tmp = (int)R1.getData() + (int)R2.getData();
            ((SREG)RegisterFile.getInstance().getRegister("SREG")).setCBit( (tmp & (1<<8)) > 0 );
//
//            Byte oldValOfR1 =
//            R1.add(R2);
        };break;
        case SUB:{

            R1.sub(R2);
        };break;

        case MUL:{
            R1.mul(R2);
        };break;

        case AND:{
            R1.and(R2);
        };break;

        case OR:{
            R1.or(R2);
        };break;

        case JR:{
            ((ProgramCounter)RegisterFile.getInstance().getRegister("PC")).jump(R1,R2);
        }break;

        default:{
            throw new InvalidInstructionException();
        }
        }
    }

    public void ImmediateInstruction(){

    }



    public static ALU getInstance() {
        if(ALU.instance == null) ALU.instance= new ALU();
        return ALU.instance;
    }



}
