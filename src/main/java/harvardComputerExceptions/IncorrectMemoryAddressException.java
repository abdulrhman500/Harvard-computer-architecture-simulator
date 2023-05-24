package harvardComputerExceptions;

public class IncorrectMemoryAddressException extends HarvardComputerArchException{

    public IncorrectMemoryAddressException(){ super(); }
    public IncorrectMemoryAddressException(String message) {super(message);}
    public IncorrectMemoryAddressException(Exception e) { super(e);}
}
