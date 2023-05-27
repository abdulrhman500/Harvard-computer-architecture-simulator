package harvard.harvardComputerExceptions;

public class InvalidInstructionException extends HarvardComputerArchException{
    public InvalidInstructionException(){}
    public InvalidInstructionException(String message){
        super(message);
    }
    public InvalidInstructionException(Exception e){
        super(e);
    }
}
