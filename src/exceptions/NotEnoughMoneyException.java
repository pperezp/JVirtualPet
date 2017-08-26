package exceptions;

/**
 *
 * @author pperezp
 */
public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String msg) {
        super(msg);
    }
}
