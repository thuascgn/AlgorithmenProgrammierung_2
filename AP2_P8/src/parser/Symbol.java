package parser;
import java.util.EnumSet;
import java.util.Set;

/**
 * Die Konstanten PLUS ... benennen die unterschiedlichen Eingabesymbole.
 * Die Mengen ADD_OPS ... stehen fuer verwandte Symbole.
 */
enum Symbol {PLUS, MINUS, MULT, DIV, LP, RP, NUMBER, LET, ASSIGN, ID, EOL, EOF;

    static final Set<Symbol> ADD_OPS = EnumSet.of(PLUS, MINUS);
    static final Set<Symbol> MUL_OPS = EnumSet.of(MULT, DIV);
    static final Set<Symbol> UNARY_OPS = EnumSet.of(PLUS, MINUS);
}