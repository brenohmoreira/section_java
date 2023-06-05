package database;

// Exceção personalizada para integridade referencial
/*
 * Digamos que existam pessoas no departamento 3, aí excluímos esse departamento. Nesse momento, deve acontecer a
 * DbIntegrityException.
 */
public class DbIntegrityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DbIntegrityException(String message) {
        super(message);
    }
}
