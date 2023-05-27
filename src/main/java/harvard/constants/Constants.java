package harvard.constants;

public class Constants {

    public static final int DATA_MEMORY_SIZE = 2048;
    public static final int INSTRUCTION_MEMORY_SIZE = 1024;

    public static final String PROGRAM_PATH = "src/main/java/harvard/programs/program.txt";
    public static final int REGISTER_FILE_SIZE = 64;

    public static final int ADD_OPCODE = 0;
    public static final int SUB_OPCODE = 1;
    public static final int MUL_OPCODE = 2;
    public static final int LDI_OPCODE = 3;
    public static final int BEQZ_OPCODE = 4;
    public static final int AND_OPCODE = 5;
    public static final int OR_OPCODE = 6;
    public static final int JR_OPCODE = 7;
    public static final int SLC_OPCODE = 8;
    public static final int SRC_OPCODE = 9;
    public static final int LB_OPCODE = 10;
    public static final int SB_OPCODE = 11;

    public static final int[] R_TYPE_INSTRUCTIONS = {ADD_OPCODE, SUB_OPCODE, MUL_OPCODE, AND_OPCODE, OR_OPCODE,
            JR_OPCODE};
    public static final int[] I_TYPE_INSTRUCTIONS = {LDI_OPCODE, BEQZ_OPCODE, SLC_OPCODE, SRC_OPCODE, LB_OPCODE,
            SB_OPCODE};

    public static final int OFFSET = -2;
    public static final int BIT6 = 5;

    public static final int EIGHT_ONES_MASK = (1 << 8) - 1;
    public static final int FOUR_ONES_MASK = (1 << 4) - 1;
    public static final char ASSEMBLY_COMMENT_CHAR = '#';
    public static final String ASSEMBLY_SYNTAX_ERROR = "NOT VALID ASSEMBLY SYNTAX , ERROR AT : ";
    public static final String ASSEMBLY_SYNTAX_ERROR_AT_THIRD_INPUT = "Third parameter of I type instruction should be a number ,But found ";
    public static final String ASSEMBLY_SYNTAX_ERROR_AT_SECOND_INPUT = "Second parameter register ,But found ";
    public static final String OPCODE_ERROR = "OPCODE NOT DEFINED, Found : ";
    public static final String NEGATIVE_NUMBER_ERROR = "Negative numbers are not allowed";
}
