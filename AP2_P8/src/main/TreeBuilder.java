package main;
import parser.Builder;
import tree.DivNode;
import tree.MinusNode;
import tree.NegateNode;
import tree.Node;
import tree.NumberNode;
import tree.PlusNode;
import tree.TimesNode;

/**
 * Builds an Abstract Syntax Tree.
 */
public class TreeBuilder implements Builder<Node> {

    public Node plus(Node left, Node right) {
        return new PlusNode(left, right);
    }

    public Node minus(Node left, Node right) {
        return new MinusNode(left, right);
    }

    public Node times(Node left, Node right) {
        return new TimesNode(left, right);
    }

    public Node div(Node left, Node right) {
        return new DivNode(left, right);
    }

    public Node negate(Node expression) {
        return new NegateNode(expression);
    }

    public Node number(String number) {
        return new NumberNode(Double.parseDouble(number));
    }
}
