// Generated from psemantico\Expressoes.g4 by ANTLR 4.7.2
package psemantico;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressoesParser}.
 */
public interface ExpressoesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(ExpressoesParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(ExpressoesParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(ExpressoesParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(ExpressoesParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExpressoesParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExpressoesParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(ExpressoesParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(ExpressoesParser.TermoContext ctx);
}