package model.exceptions;

/*
 * Se a exceção personalizada extender para exception, você será obrigado a tratá-la com try (se não, não executa)
 * Se a exceção personalizada extender para RuntimeException, não é obrigado
 */

import java.io.Serial;

public class DomainException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public DomainException (String message) {
        super(message);
    }
}
