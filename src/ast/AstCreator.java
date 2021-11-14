package ast;

import parser.exprBaseVisitor;
import parser.exprParser;

import java.util.ArrayList;

public class AstCreator extends exprBaseVisitor<Ast>{

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProgram(grammaireParser.ProgramContext ctx) {
		ArrayList<Ast> list= new ArrayList<>();

		for(int i=0;i<ctx.getChildCount()-1;i++){
			list.add(ctx.getChild(i).accept(this));
		}
		return new InstrList(list); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDecl(grammaireParser.DeclContext ctx) {
		return ctx.getChild(0).accept(this);}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDecl_typ(grammaireParser.Decl_typContext ctx) {

		String idfString = ctx.getChild(1).toString();
		Idf idf = new Idf(idfString);

		ArrayList<Ast> list= new ArrayList<>();
		for(int i=3;i<ctx.getChildCount()-2;i++){
			list.add(ctx.getChild(i).accept(this));
		}

		return new DeclType(list,idf);
		 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIntDecl(grammaireParser.IntDeclContext ctx) {
		ArrayList<Ast> list= new ArrayList<>();
		for(int i=1;i<ctx.getChildCount()-1;i=i+2){
			String idfString = ctx.getChild(i).toString();
			Idf idf = new Idf(idfString);
			list.add(idf);
		}
		return new DeclInt(list);
	}

		 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStructDecl(grammaireParser.StructDeclContext ctx) {
		ArrayList<Ast> list= new ArrayList<>();

		String idfString = ctx.getChild(i).toString();
		Idf idf = new Idf(idfString);
		list.add(idf);

		for(int i=3;i<ctx.getChildCount()-1;i=i+3){
			String idfString = ctx.getChild(i).toString();
			Idf idf = new Idf(idfString);
			list.add(idf);
		}
		return new DeclStruct(list); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIntFct(grammaireParser.IntFctContext ctx) {
		Ast params = ctx.getChild(3).accept(this);
		Ast bloc = ctx.getChild(5).accept(this);
		String idf1String = ctx.getChild(1).toString();

		Idf idf1 = new Idf(idf1String);

		return new StructFct(idf1,params,bloc) }
 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStructFct(grammaireParser.StructFctContext ctx) {
		Ast params = ctx.getChild(5).accept(this);
		Ast bloc = ctx.getChild(7).accept(this);
		String idf1String = ctx.getChild(1).toString();
		String idf2String = ctx.getChild(3).toString();

		Idf idf1 = new Idf(idf1String);
		Idf idf2 = new Idf(idf2String);

		return new StructFct(idf1,idf2,params,bloc) }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParametre(grammaireParser.ParametreContext ctx) {
		return ctx.getChild(0).accept(this); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParametres(grammaireParser.ParametresContext ctx) {

		ArrayList<Ast> list= new ArrayList<>();

		for(int i=0;i<ctx.getChildCount();i++){
		list.add(ctx.getChild(i).accept(this));
		}
		return new Parametres(list);}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIntParam(grammaireParser.IntParamContext ctx) {
		String idfString = ctx.getChild(1).toString();

		//Création des sous AST
		Idf idf = new Idf(idfString);

		return new IntParam(idf);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStructPointer(grammaireParser.StructPointerContext ctx) {
		String idf1String = ctx.getChild(1).toString();
		String idf2String = ctx.getChild(3).toString();

		Idf idf1 = new Idf(idf1String);
		Idf idf2 = new Idf(idf2String);

		return new StructPointer(idf1,idf2); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBloc(grammaireParser.BlocContext ctx) {
		ArrayList<Ast> list= new ArrayList<>();
		//if empty list?
		for(int i=1;i<ctx.getChildCount()-1;i++){
			list.add(ctx.getChild(i).accept(this));
		}
		return new Bloc(list);


		 }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitNone(grammaireParser.NoneContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpression(grammaireParser.ExpressionContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAffectation(grammaireParser.AffectationContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIfInst(grammaireParser.IfInstContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitWhileInst(grammaireParser.WhileInstContext ctx) {
		return ctx.getChild(0).accept(this); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitBlocInst(grammaireParser.BlocInstContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitReturn(grammaireParser.ReturnContext ctx) {
		return ctx.getChild(1).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIfThen(grammaireParser.IfThenContext ctx) {

		Ast condition = ctx.getChild(2).accept(this);
		Ast thenBlock = ctx.getChild(4).accept(this);

		return new IfThen(condition,thenBlock);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIfThenElse(grammaireParser.IfThenElseContext ctx) {

		Ast condition = ctx.getChild(2).accept(this);
		Ast thenBlock = ctx.getChild(4).accept(this);
		Ast elseBlock = ctx.getChild(6).accept(this);
		return new IfThenElse(condition,thenBlock);

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitWhile_instruction(grammaireParser.While_instructionContext ctx) {
		Ast condition = ctx.getChild(2).accept(this);
		Ast instruction = ctx.getChild(4).accept(this);

		return new WhileInst(condition,instruction); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIdfAffect(grammaireParser.IdfAffectContext ctx) {

		Ast expr = ctx.getChild(2).accept(this);
		String idfString = ctx.getChild(0).toString();

		Idf idf = new Idf(idfString);

		return new IdfAffect(idf,expr);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFlecheAffect(grammaireParser.FlecheAffectContext ctx) {
		Ast expr = ctx.getChild(2).accept(this);
		Ast fleche = ctx.getChild(0).accept(this);

		return new FlecheAffect(fleche,expr); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpr(grammaireParser.ExprContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOr_op(grammaireParser.Or_opContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			noeudTemporaire = new OuLogique(noeudTemporaire,right);
			}
		return noeudTemporaire;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEt_op(grammaireParser.Et_opContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			noeudTemporaire = new EtLogique(noeudTemporaire,right);
		}
		return noeudTemporaire;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitEgalite(grammaireParser.EgaliteContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			switch (operation) {
				case "==":
					noeudTemporaire = new EqualTo(noeudTemporaire,right);
					break;
				case "!=":
					noeudTemporaire = new NotEqualTo(noeudTemporaire,right);
					break;
				default:
					break;
			}
		}
		return noeudTemporaire;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitComparaison(grammaireParser.ComparaisonContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			switch (operation) {
				case "<":
					noeudTemporaire = new LessThan(noeudTemporaire,right);
					break;
				case "<=":
					noeudTemporaire = new LessOrEqual(noeudTemporaire,right);
					break;
				case ">":
					noeudTemporaire = new GreaterThan(noeudTemporaire,right);
					break;
				case ">=":
					noeudTemporaire = new GreaterOrEqual(noeudTemporaire,right);
					break;
				default:
					break;
			}
		}
		return noeudTemporaire;
	}



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSomme(grammaireParser.SommeContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){

			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);

			switch (operation) {
				case "-":
					noeudTemporaire = new Minus(noeudTemporaire,right);
					break;
				case "+":
					noeudTemporaire = new Plus(noeudTemporaire,right);
					break;
				default:
					break;
			}
		}
		return noeudTemporaire;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitProduit(grammaireParser.ProduitContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){

			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);

			switch (operation) {
				case "*":
					noeudTemporaire = new Mult(noeudTemporaire,right);
					break;
				case "/":
					noeudTemporaire = new Divide(noeudTemporaire,right);
					break;
				default:
					break;
			}
		}
		return noeudTemporaire;

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitOppose(grammaireParser.OpposeContext ctx) {
		int dernier = ctx.getChildCount();
		return  ctx.getChild(dernier).accept(this)}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFleche(grammaireParser.FlecheContext ctx) {
		String idf1String = ctx.getChild(0).toString();
		String idf2String = ctx.getChild(2).toString();
		return Arrow(idf1String,idf2String);
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitInteger(grammaireParser.IntegerContext ctx) {
		String str = ctx.getChild(0).toString();
		int integer=Integer.parseInt(str);
		return new Integer(integer);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitIdentifier(grammaireParser.IdentifierContext ctx) {
		String idf = ctx.getChild(0).toString();
		return new Idf(idf);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitArrow(grammaireParser.ArrowContext ctx) {

		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitFunction(grammaireParser.FunctionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSizeof(grammaireParser.SizeofContext ctx) {

		return ctx.getChild(3).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParenthesis(grammaireParser.ParenthesisContext ctx) {

		return ctx.getChild(1).accept(this);
	}
}
