package exceptions;

/**
 *
 * @author pperezp
 */
public class FoodNotFoundException extends Exception {

    public FoodNotFoundException() {
    }

    public FoodNotFoundException(String msg) {
        super(msg);
    }
}
