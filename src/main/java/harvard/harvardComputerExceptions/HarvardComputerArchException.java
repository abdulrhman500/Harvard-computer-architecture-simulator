package harvard.harvardComputerExceptions;

public class HarvardComputerArchException extends Exception{
    public HarvardComputerArchException(){ super(); }
    public HarvardComputerArchException(String message) {super(message);}
    public HarvardComputerArchException(Exception e) { super(e);}
}
