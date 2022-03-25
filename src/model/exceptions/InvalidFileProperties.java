package model.exceptions;

public class InvalidFileProperties extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidFileProperties(String msg) {
		super(msg);
	}
}
