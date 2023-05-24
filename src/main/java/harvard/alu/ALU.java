package harvard.alu;

import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.harvardComputerExceptions.InvalidInstructionException;
import harvard.instruction.Instuctions;
import harvard.memory.RegisterFile;
import harvard.storage.ProgramCounter;
import harvard.storage.Register;
import harvard.storage.SREG;


public class ALU {

    static ALU instance = null;

    private ALU() {

    }

    public void RegisterInstruction(Instuctions instruction, String firstRegister, String secondRegister)
            throws InvalidInstructionException {
        RegisterFile registerFile = RegisterFile.getInstance();
        Register R1 = registerFile.getRegister(firstRegister);
        Register R2 = registerFile.getRegister(secondRegister);
        switch (instruction) {
            case ADD: {
                // TODO: check about zero
                int inttmp = ((int) R1.getData() + (int) R2.getData());
                byte bytetmp = (byte) inttmp;
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setCBit((inttmp & (1 << 8)) > 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG"))
                        .setVBit((R1.getData() > 0 && R2.getData() > 0 && bytetmp < 0) ||
                                (R1.getData() < 0 && R2.getData() < 0 && bytetmp > 0));
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setNBit(bytetmp < 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setSBit();
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setZBit(bytetmp == 0);
                R1.add(R2);
            }
                ;
                break;
            case SUB: {
                // TODO: check about zero
                byte tmp = (byte) ((int) R1.getData() - (int) R2.getData());
                ((SREG) RegisterFile.getInstance().getRegister("SREG"))
                        .setVBit((R1.getData() > 0 && R2.getData() < 0 && tmp < 0) ||
                                (R1.getData() < 0 && R2.getData() > 0 && tmp > 0));
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setNBit(tmp < 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setSBit();
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setZBit(tmp == 0);
                R1.sub(R2);
            }
                ;
                break;

            case MUL: {
                byte tmp = (byte) ((int) R1.getData() * (int) R2.getData());
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setNBit(tmp < 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setZBit(tmp == 0);
                R1.mul(R2);
            }
                ;
                break;

            case AND: {
                byte tmp = (byte) ((int) R1.getData() & (int) R2.getData());
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setNBit(tmp < 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setZBit(tmp == 0);
                R1.and(R2);
            }
                ;
                break;

            case OR: {
                byte tmp = (byte) ((int) R1.getData() | (int) R2.getData());
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setNBit(tmp < 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setZBit(tmp == 0);
                R1.or(R2);
            }
                ;
                break;

            case JR: {
                ((ProgramCounter) RegisterFile.getInstance().getRegister("PC")).jump(R1, R2);
            }
                break;

            default: {
                throw new InvalidInstructionException();
            }
        }
    }

    public void ImmediateInstruction(Instuctions instruction, String register, byte imm)
            throws InvalidInstructionException, IncorrectMemoryAddressException {
        RegisterFile registerFile = RegisterFile.getInstance();
        Register R = registerFile.getRegister(register);
        switch (instruction) {
            case LDI: {
                R.setData(imm);
            }
                break;
            case BEQZ: {
                ((ProgramCounter) (registerFile.getRegister("PC"))).BEQZ(R, imm);
            }
                break;
            case SLC: {
                R.shiftLeft(imm);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setNBit(R.getData() < 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setZBit(R.getData() == 0);
            }
                break;
            case SRC: {
                R.shiftRight(imm);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setNBit(R.getData() < 0);
                ((SREG) RegisterFile.getInstance().getRegister("SREG")).setZBit(R.getData() == 0);
            }
                break;
            case LB: {
                R.loadByte(imm);
            }
                break;
            case SB: {
                R.storeByte(imm);
            }
                break;
            default:
                throw new InvalidInstructionException();
        }
    }

    public static ALU getInstance() {
        if (ALU.instance == null)
            ALU.instance = new ALU();
        return ALU.instance;
    }

    public static void main(String[] args) {
        byte m1 = 127;
        byte m2 = 127;
        int tmp1 = ((int) m1 + (int) m2);
        byte tmp2 = (byte) tmp1;
        System.out.println(tmp1);
        System.out.println(tmp2);
    }
}
