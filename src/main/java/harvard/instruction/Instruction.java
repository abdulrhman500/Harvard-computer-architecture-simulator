package harvard.instruction;

import harvard.harvardComputerExceptions.HarvardComputerArchException;

public interface Instruction {

	void doOperation() throws HarvardComputerArchException;

	void updateFlags(int result) throws HarvardComputerArchException;

}
