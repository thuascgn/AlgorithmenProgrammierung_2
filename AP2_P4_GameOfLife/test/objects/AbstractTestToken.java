package objects;

public abstract class AbstractTestToken {
	protected Token object;
	protected static final Token W = WhiteToken.instance();
	protected static final Token B = BlackToken.instance();

	protected static final Token[] ts1 = {W,W,W,W,W,W,B,W};
	protected static final Token[] ts2 = {W,W,W,B,W,W,B,W};
	protected static final Token[] ts3 = {W,B,B,W,W,W,B,W};
	protected static final Token[] ts4 = {W,B,B,W,W,W,B,B};
}
