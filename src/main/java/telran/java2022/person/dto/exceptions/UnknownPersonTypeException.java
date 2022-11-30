package telran.java2022.person.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnknownPersonTypeException extends RuntimeException {

	private static final long serialVersionUID = -4305106419613378643L;

	/**
	 * 
	 */

}
