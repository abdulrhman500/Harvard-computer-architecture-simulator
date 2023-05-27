package harvard.constants;

public class Constants {

    public static final int DATA_MEMORY_SIZE = 2048 ;
    public static final int INSTRUCTION_MEMORY_SIZE = 1024 ;

    public static final String PROGRAM_PATH="src/main/java/harvard/programs/program.txt";

    public static final int EIGHT_ONES_MASK = (1<<8)-1;
    public static final int FOUR_ONES_MASK = (1<<4)-1;

    public static final String R_NAME_REGISTER = "R";

    public static final String PC_NAME_REGISTER = "PC";

    public static final String SREG_NAME_REGISTER = "SERG";

    public static final short PC_BITS_NUMBER = 0b1111111111;

    public static final short MEMORY_BITS_NUMBER = 0b11111111111;

    public static final byte BYTE_NUMBER_BITS = (byte) 0b11111111;

}
