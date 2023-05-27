package harvard.parser;

import harvard.constants.Constants;
import harvard.harvardComputerExceptions.IncorrectMemoryAddressException;
import harvard.harvardComputerExceptions.InvalidInstructionException;
import harvard.memory.InstructionMemory;

import java.io.*;
import java.nio.Buffer;

public class Parser {
    String path;
    public Parser(String path){
        this.path = path;
    }

    public void parseFile() throws IOException, InvalidInstructionException, IncorrectMemoryAddressException {
        BufferedReader buffer = new BufferedReader(new FileReader(path));
        while (buffer.ready())
        {
            String line = buffer.readLine();
            String [] parse = line.split(" ");
            byte opcode = -1;
            System.out.println();
            String R1 = comBits(Integer.toBinaryString(Integer.parseInt(parse[1].substring(1)))).substring(26);
            String ImmR2 = (parse[2].toLowerCase()).charAt(0)=='r'?
                        parse[2].substring(1):parse[2];
            ImmR2 = comBits(Integer.toBinaryString(Integer.parseInt(ImmR2))).substring(26);
            switch (parse[0].toLowerCase()){
                case "add":
                    opcode = Constants.ADD_OPCODE;
                    break;
                case "sub":
                    opcode = Constants.SUB_OPCODE;
                    break;
                case "mul":
                    opcode = Constants.MUL_OPCODE;
                    break;
                case "ldi":
                    opcode = Constants.LDI_OPCODE;
                    break;
                case "beqz":
                    opcode = Constants.BEQZ_OPCODE;
                    break;
                case "and":
                    opcode = Constants.AND_OPCODE;
                    break;
                case "or":
                    opcode = Constants.OR_OPCODE;
                    break;
                case "jr":
                    opcode = Constants.JR_OPCODE;
                    break;
                case "slc":
                    opcode = Constants.SLC_OPCODE;
                    break;
                case "src":
                    opcode = Constants.SRC_OPCODE;
                    break;
                case "lb":
                    opcode = Constants.LB_OPCODE;
                    break;
                case "sb":
                    opcode = Constants.SB_OPCODE;
                    break;
                default:
                    throw new InvalidInstructionException("wrong instruction");
            }
            String opcodeStr = comBits(Integer.toBinaryString(opcode)).substring(28);
            String conc = opcodeStr+R1+ImmR2;
            short instruction = (short) Integer.parseInt(conc,2);
            InstructionMemory.getInstance().addInstruction(instruction);
        }
    }
String comBits(String m){
        while (m.length()<32){
            m = "0"+m;
        }
        return m;
}
}
