package bitcamp.java110.cms.dao;

public class DuplicationDAOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DuplicationDAOException() {
        super();
    }

    public DuplicationDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationDAOException(String message) {
        super(message);
    }

}
