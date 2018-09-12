package bitcamp.java110.cms.dao;

public class MandatoryValueDAOException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MandatoryValueDAOException() {
        super();
    }

    public MandatoryValueDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public MandatoryValueDAOException(String message) {
        super(message);
    }

}
