package harvard.harvardComputerExceptions;

import harvard.harvardComputerExceptions.HarvardComputerArchException;

public class InvalidInstructionException extends HarvardComputerArchException {

    public InvalidInstructionException(){ super(); }
    public InvalidInstructionException(String message) {super(message);}
    public InvalidInstructionException(Exception e) { super(e);}
}
