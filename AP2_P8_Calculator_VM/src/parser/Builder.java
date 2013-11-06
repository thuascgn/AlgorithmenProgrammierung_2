package parser;

/**
 * These methods are called when the appropriate expression is parsed.
 *
 * @param <T> Type of the product
 */
public interface Builder<T> {
    /**
     * Compiles left + right.
     * @param left left-operand
     * @param right right-operand
     * @return the product for this operation
     */
    public T plus(T left, T right);
    /**
     * Compiles left - right.
     * @param left left-operand
     * @param right right-operand
     * @return the product for this operation
     */
    public T minus(T left, T right);
    /**
     * Compiles left * right.
     * @param left left-operand
     * @param right right-operand
     * @return the product for this operation
     */
    public T times(T left, T right);
    /**
     * Compiles left / right.
     * @param left left-operand
     * @param right right-operand
     * @return the product for this operation
     */
    public T div(T left, T right);
    /**
     * Compiles -operand.
     * @param operand to be negated
     * @return the product for this operation
     */
    public T negate(T operand);
    /**
     * Compiles a (double) number.
     * @param number String-representation of double number
     * @return the product for this operation
     */
    public T number(String number);
}
