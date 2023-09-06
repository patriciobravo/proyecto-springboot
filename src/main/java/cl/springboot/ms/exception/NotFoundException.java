package cl.springboot.ms.exception;

public class NotFoundException extends DomainException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(DomainExceptionCode code) {
        super(code);
    }
}
