package ast;

import parser.grammaireBaseVisitor;
import parser.grammaireParser;

import java.util.ArrayList;

public class AstCreator extends grammaireBaseVisitor<Ast> {

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitProgram(grammaireParser.ProgramContext ctx) {
		ArrayList<Ast> list= new ArrayList<>();

		for(int i=0; i<ctx.getChildCount()-1; i++) {
			list.add(ctx.getChild(i).accept(this));
		}
		return new DeclList(list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitDecl(grammaireParser.DeclContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitDecl_typ(grammaireParser.Decl_typContext ctx) {

		String idfString = ctx.getChild(1).toString();
		Idf idf = new Idf(idfString);

		ArrayList<Ast> list = new ArrayList<>();
		for (int i=3; i<ctx.getChildCount()-2; i++) {
			list.add(ctx.getChild(i).accept(this));
		}
		return new DeclType(idf, list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIntDecl(grammaireParser.IntDeclContext ctx) {
		ArrayList<Ast> list = new ArrayList<>();
		
		for (int i=1; i<ctx.getChildCount()-1; i+=2) {
			String idfString = ctx.getChild(i).toString();
			Idf idf = new Idf(idfString);
			list.add(idf);
		}
		return new DeclInt(list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitStructDecl(grammaireParser.StructDeclContext ctx) {
		ArrayList<Ast> list= new ArrayList<>();

		String idfStruct = ctx.getChild(1).toString();
		Idf idf_struct = new Idf(idfStruct);

		for(int i=3;i<ctx.getChildCount()-1;i=i+3){
			String idfString = ctx.getChild(i).toString();
			Idf idf = new Idf(idfString);
			list.add(idf);
		}
		return new DeclStruct(idf_struct, list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIntFct(grammaireParser.IntFctContext ctx) {
		Ast params = ctx.getChild(3).accept(this);
		Ast bloc = ctx.getChild(5).accept(this);

		String idfString = ctx.getChild(1).toString();
		Idf idf = new Idf(idfString);

		return new IntFct(idf, params, bloc);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitStructFct(grammaireParser.StructFctContext ctx) {
		Ast params = ctx.getChild(5).accept(this);
		Ast bloc = ctx.getChild(7).accept(this);

		String idfStruct = ctx.getChild(1).toString();
		String idfString = ctx.getChild(3).toString();
		Idf idf_struct = new Idf(idfStruct);
		Idf idf = new Idf(idfString);

		return new StructFct(idf_struct, idf, params, bloc);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitParametre(grammaireParser.ParametreContext ctx) {
		if (ctx.getChildCount() != 0) {
			return ctx.getChild(0).accept(this);
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitParametres(grammaireParser.ParametresContext ctx) {

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
	@Override public Ast visitIntParam(grammaireParser.IntParamContext ctx) {
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
	@Override public Ast visitStructPointer(grammaireParser.StructPointerContext ctx) {
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
	@Override public Ast visitBloc(grammaireParser.BlocContext ctx) {
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
	@Override public Ast visitNone(grammaireParser.NoneContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitExpression(grammaireParser.ExpressionContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitAffectation(grammaireParser.AffectationContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIfInst(grammaireParser.IfInstContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitWhileInst(grammaireParser.WhileInstContext ctx) {
		return ctx.getChild(0).accept(this); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitBlocInst(grammaireParser.BlocInstContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitReturn(grammaireParser.ReturnContext ctx) {
		return ctx.getChild(1).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIfThen(grammaireParser.IfThenContext ctx) {

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
	@Override public Ast visitIfThenElse(grammaireParser.IfThenElseContext ctx) {

		Ast condition = ctx.getChild(2).accept(this);
		Ast thenBlock = ctx.getChild(4).accept(this);
		Ast elseBlock = ctx.getChild(6).accept(this);
		return new IfThenElse(condition,thenBlock,elseBlock);

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitWhile_instruction(grammaireParser.While_instructionContext ctx) {
		Ast condition = ctx.getChild(2).accept(this);
		Ast instruction = ctx.getChild(4).accept(this);

		return new WhileInst(condition,instruction); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIdfAffect(grammaireParser.IdfAffectContext ctx) {

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
	@Override public Ast visitFlecheAffect(grammaireParser.FlecheAffectContext ctx) {
		Ast expr = ctx.getChild(2).accept(this);
		Ast fleche = ctx.getChild(0).accept(this);

		return new FlecheAffect(fleche,expr); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitExpr(grammaireParser.ExprContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitOr_op(grammaireParser.Or_opContext ctx) {
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
	@Override public Ast visitEt_op(grammaireParser.Et_opContext ctx) {
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
	@Override public Ast visitEgalite(grammaireParser.EgaliteContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			switch (operation) {
				case "==" -> noeudTemporaire = new EqualTo(noeudTemporaire, right);
				case "!=" -> noeudTemporaire = new NotEqualTo(noeudTemporaire, right);
				default -> {
				}
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
	@Override public Ast visitComparaison(grammaireParser.ComparaisonContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			switch (operation) {
				case "<" -> noeudTemporaire = new LessThan(noeudTemporaire, right);
				case "<=" -> noeudTemporaire = new LessOrEqual(noeudTemporaire, right);
				case ">" -> noeudTemporaire = new GreaterThan(noeudTemporaire, right);
				case ">=" -> noeudTemporaire = new GreaterOrEqual(noeudTemporaire, right);
				default -> {
				}
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
	@Override public Ast visitSomme(grammaireParser.SommeContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){

			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);

			switch (operation) {
				case "-" -> noeudTemporaire = new Minus(noeudTemporaire, right);
				case "+" -> noeudTemporaire = new Plus(noeudTemporaire, right);
				default -> {
				}
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
	@Override public Ast visitProduit(grammaireParser.ProduitContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0;2*i<ctx.getChildCount()-1;i++){
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			switch (operation) {
				case "*" -> noeudTemporaire = new Mult(noeudTemporaire, right);
				case "/" -> noeudTemporaire = new Divide(noeudTemporaire, right);
				default -> {
				}
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
	@Override public Ast visitOppose(grammaireParser.OpposeContext ctx) {
		int dernier = ctx.getChildCount();
		return  ctx.getChild(dernier).accept(this);}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitFleche(grammaireParser.FlecheContext ctx) {
		String idf1String = ctx.getChild(0).toString();
		String idf2String = ctx.getChild(2).toString();
		Idf idf1 = new Idf(idf1String);
		Idf idf2 = new Idf(idf2String);

		return new Fleche(idf1,idf2);
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitInteger(grammaireParser.IntegerContext ctx) {
		String str = ctx.getChild(0).toString();
		int integer=Integer.parseInt(str);
		return new Entier(integer);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIdentifier(grammaireParser.IdentifierContext ctx) {
		String idf = ctx.getChild(0).toString();
		return new Idf(idf);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitArrow(grammaireParser.ArrowContext ctx) {

		return ctx.getChild(0).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitFunction(grammaireParser.FunctionContext ctx) {
		String idfString = ctx.getChild(2).toString();
		Idf idf = new Idf(idfString);
		ArrayList<Ast> list= new ArrayList<>();
		for(int i=2;i<ctx.getChildCount()-1;i=i+2){
			list.add(ctx.getChild(i).accept(this));
		}
		return new Function(idf,list); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitSizeof(grammaireParser.SizeofContext ctx) {

		return ctx.getChild(3).accept(this);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitParenthesis(grammaireParser.ParenthesisContext ctx) {

		return ctx.getChild(1).accept(this);
	}
}
