package parser;

/**
 * Recursive descent parser for a simple arithmetic expression.
 */
public class Parser<T> {    
    private Scanner scanner;
    private Builder<T> builder;
    
    /**
     * parses the input and computes its value.
     * 
     * @param input input to be parsed
     * @return result of evaluation
     * @throws IllegalArgumentException if the input contains syntax errors
     * @throws ArithmeticException on division by 0
     */
    public static <T> T parse(String input, Builder<T> builder) {
        return new Parser<T>(input, builder).parse();
    }
    
    /**
     * creates a new Parser.
     * 
     * @param input input line to be evaluated
     * @param builder builds the product
     */
    private Parser(String input, Builder<T> builder) {
        scanner = new Scanner(input);
        this.builder = builder;
    }
    
    /**
     * parses the complete input line.
     * <pre>
     *    line -> expression EOL
     *         |  let name = expression EOL
     * </pre>
     * @return value of line as build by the builder that
     *          was passed to the constructor
     * @throws IllegalArgumentException if the input contains syntax errors
     */
    private T parse() {
        if (scanner.lookahead() == Symbol.EOF) {
            scanner.match(Symbol.EOF);
            scanner.match(Symbol.EOL);
            System.exit(0);
        }
        T result = expression();
        scanner.match(Symbol.EOL);
        return result;
    }

    /**
     * parses additive operations.
     * <pre>
     *   expression -> term exprR
     *   exprR -> + term exprR
     *   exprR -> - term exprR
     *   exprR -> 
     * </pre>
     * @return value of expression
     */
    T expression() { return exprR(term()); }
    T exprR(T sum) {
        switch (scanner.nextOf(Symbol.ADD_OPS)) {
        case PLUS: return exprR(builder.plus(sum, term()));
        case MINUS:return exprR(builder.minus(sum, term()));
        default:   return sum;
        }
    }

    /**
     * parses multiplicative operations.
     * <pre>
     *   term -> factor termR
     *   termR -> * factor termR
     *   termR -> / factor termR
     *   termR ->
     * </pre>
     * @return value of term
     */
    T term() { return termR(factor()); }
    T termR(T product) {
        switch (scanner.nextOf(Symbol.MUL_OPS)) {
        case MULT: return termR(builder.times(product, factor()));
        case DIV:  return termR(builder.div(product, factor()));
        default:   return product;
        }
    }

    /**
     * parses unary operations.
     * <pre>
     *   factor -> + factor
     *   factor -> - factor
     *   factor -> primitive
     * </pre>
     * @return value of factor
     */
    T factor() {
        switch(scanner.nextOf(Symbol.UNARY_OPS)) {
        case PLUS: return factor();
        case MINUS:return builder.negate(factor());
        default:   return primitive();
        }
    }
    
    /**
     * parses a most primitive term.
     * <pre>
     * primitive -> ( expression )
     * primitive -> NUMBER
     * </pre>
     * @return value of primitive
     */
    T primitive() {;
        switch (scanner.lookahead()) {
        case LP:
            scanner.match(Symbol.LP);
            T result = expression();
            scanner.match(Symbol.RP);
            return result;
        case NUMBER:
            return builder.number(scanner.match(Symbol.NUMBER));
        default:
            throw new IllegalArgumentException("syntax error");
        }
    }
}
