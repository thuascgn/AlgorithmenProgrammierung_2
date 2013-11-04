package tree;

import vm.OpCode;

public class TimesNode extends BinOpNode {
    
	public TimesNode(Node left, Node right) {
		super(left, right);
	}

    protected OpCode opCode() {
        return OpCode.TIMES;
    }
}
