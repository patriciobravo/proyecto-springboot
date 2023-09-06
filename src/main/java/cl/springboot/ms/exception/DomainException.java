package cl.springboot.ms.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DomainExceptionCode code;

    protected DomainException(DomainExceptionCode code) {

        this.code = code;
    }

    protected DomainException(DomainExceptionCode code, Throwable throwable) {

        super(throwable);
        this.code = code;
    }
}
