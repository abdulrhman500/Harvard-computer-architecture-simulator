package harvardComputerExceptions;

public class InvalidInstructionException extends HarvardComputerArchException {

    public InvalidInstructionException(){ super(); }
    public InvalidInstructionException(String message) {super(message);}
    public InvalidInstructionException(Exception e) { super(e);}
}
