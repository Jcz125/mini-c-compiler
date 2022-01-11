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
		return new Program(list);
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
		Idf idf = new Idf(idfString, ctx.getStart().getLine());

		ArrayList<Ast> list = new ArrayList<>();
		for (int i=3; i<ctx.getChildCount()-2; i++) {
			list.add(ctx.getChild(i).accept(this));
		}

		return new DeclType(idf, list, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIntDecl(grammaireParser.IntDeclContext ctx) {
		ArrayList<Idf> list = new ArrayList<>();
		
		for (int i=1; i<ctx.getChildCount()-1; i+=2) {
			String idfString = ctx.getChild(i).toString();
			Idf idf = new Idf(idfString, ctx.getStart().getLine());
			list.add(idf);
		}
		return new VarInt(list, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitStructDecl(grammaireParser.StructDeclContext ctx) {
		ArrayList<Idf> list= new ArrayList<>();

		String idfStruct = ctx.getChild(1).toString();
		Idf idf_struct = new Idf(idfStruct, ctx.getStart().getLine());

		for(int i=3; i<ctx.getChildCount()-1; i+=3){
			String idfString = ctx.getChild(i).toString();
			Idf idf = new Idf(idfString, ctx.getStart().getLine());
			list.add(idf);
		}
		return new VarStruct(idf_struct, list, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIntFct(grammaireParser.IntFctContext ctx) {
		Parametres params = (Parametres) ctx.getChild(3).accept(this);
		Ast bloc = ctx.getChild(5).accept(this);

		String idfString = ctx.getChild(1).toString();
		Idf idf = new Idf(idfString, ctx.getStart().getLine());

		return new IntFct(idf, params, bloc, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitStructFct(grammaireParser.StructFctContext ctx) {
		Parametres params = (Parametres) ctx.getChild(5).accept(this);
		Ast bloc = ctx.getChild(7).accept(this);

		String idfStruct = ctx.getChild(1).toString();
		String idfString = ctx.getChild(3).toString();
		Idf idf_struct = new Idf(idfStruct, ctx.getStart().getLine());
		Idf idf = new Idf(idfString, ctx.getStart().getLine());

		return new StructFct(idf_struct, idf, params, bloc, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitParametre(grammaireParser.ParametreContext ctx) {
		ArrayList<Ast> param = new ArrayList<>();

		if (ctx.getChildCount() != 0) {
			param.add(ctx.getChild(0).accept(this));
		} // peut-être qu'on aura besoin dans une liste new Parametres(list) avec list : singleton ou list : vide
		return new Parametres(param);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitParametres(grammaireParser.ParametresContext ctx) {
		ArrayList<Ast> list= new ArrayList<>();

		for (int i=0; i<ctx.getChildCount(); i+=2) {
			list.add(ctx.getChild(i).accept(this));
		}
		return new Parametres(list);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIntParam(grammaireParser.IntParamContext ctx) {
		String idfString = ctx.getChild(1).toString();

		//Création des sous AST
		Idf idf = new Idf(idfString, ctx.getStart().getLine());

		return new IntParam("int", idf, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitStructPointer(grammaireParser.StructPointerContext ctx) {
		String idfStruct = ctx.getChild(1).toString();
		String idfString = ctx.getChild(3).toString();

		Idf idf_struct = new Idf(idfStruct, ctx.getStart().getLine());
		Idf idf = new Idf(idfString, ctx.getStart().getLine());

		return new StructPointer(idf_struct, idf, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitBloc(grammaireParser.BlocContext ctx) {
		ArrayList<Ast> list = new ArrayList<>();
		for (int i=1; i<ctx.getChildCount()-1; i++) {
			list.add(ctx.getChild(i).accept(this));
		}
		return new Bloc(list, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitNone(grammaireParser.NoneContext ctx) {
		return null; // peut-être essayer return null; si ça ne marche pas
	}
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
		return new Return(ctx.getChild(1).accept(this), ctx.getStart().getLine());
	} // peut-être qu'il faudra ajouter un objet new Return
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIfThen(grammaireParser.IfThenContext ctx) {
		Ast condition = ctx.getChild(2).accept(this);
		Ast thenBlock = ctx.getChild(4).accept(this);

		return new IfThen(condition, thenBlock, ctx.getStart().getLine());
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

		return new IfThenElse(condition, thenBlock, elseBlock, ctx.getStart().getLine());
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

		return new WhileInst(condition, instruction, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitAffect(grammaireParser.AffectContext ctx) {
		// vérifier le type de IDF ou fleche pour traiter les deux cas
		String TerminalNodeclass = "class org.antlr.v4.runtime.tree.TerminalNodeImpl";
		Ast noeudTemporaire = ctx.getChild(ctx.getChildCount()-1).accept(this); // expr
		// ArrayList<Ast> list = new ArrayList<>();

		for (int i=ctx.getChildCount()-3; i>=0; i-=2) {
			if (TerminalNodeclass.equals(""+ctx.getChild(i).getClass())) {
				String idfString = ctx.getChild(i).toString();
				noeudTemporaire = new Affect(new Idf(idfString, ctx.getStart().getLine()), noeudTemporaire, ctx.getStart().getLine());
			} else {
				noeudTemporaire = new Affect(ctx.getChild(i).accept(this), noeudTemporaire, ctx.getStart().getLine());
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

		for (int i=0; 2*i<ctx.getChildCount()-1;i++) {
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			noeudTemporaire = new OuLogique(noeudTemporaire, right, ctx.getStart().getLine());
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

		for (int i=0; 2*i<ctx.getChildCount()-1; i++) {
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			noeudTemporaire = new EtLogique(noeudTemporaire, right, ctx.getStart().getLine());
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

		for (int i=0; 2*i<ctx.getChildCount()-1; i++) {
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);

			switch (operation) {
				case "==" :
					noeudTemporaire = new EqualTo(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				case "!=" :
					noeudTemporaire = new NotEqualTo(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				default :
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
	@Override public Ast visitComparaison(grammaireParser.ComparaisonContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

		for (int i=0; 2*i<ctx.getChildCount()-1; i++) {
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);

			switch (operation) {
				case "<" :
					noeudTemporaire = new LessThan(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				case "<=" :
					noeudTemporaire = new LessOrEqual(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				case ">" :
					noeudTemporaire = new GreaterThan(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				case ">=" :
					noeudTemporaire = new GreaterOrEqual(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				default :
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
	@Override public Ast visitSomme(grammaireParser.SommeContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);

		for (int i=0; 2*i<ctx.getChildCount()-1; i++) {
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);

			switch (operation) {
				case "-" :
					noeudTemporaire = new Minus(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				case "+" :
					noeudTemporaire = new Plus(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				default :
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
	@Override public Ast visitProduit(grammaireParser.ProduitContext ctx) {
		Ast noeudTemporaire = ctx.getChild(0).accept(this);
		for (int i=0; 2*i<ctx.getChildCount()-1; i++) {
			String operation = ctx.getChild(2*i+1).toString();
			Ast right = ctx.getChild(2*(i+1)).accept(this);
			switch (operation) {
				case "*":
					noeudTemporaire = new Mult(noeudTemporaire, right, ctx.getStart().getLine());
					break;
				case "/":
					noeudTemporaire = new Divide(noeudTemporaire, right, ctx.getStart().getLine());
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
	@Override public Ast visitOppose(grammaireParser.OpposeContext ctx) {
		int dernier = ctx.getChildCount()-1;
		if (ctx.getChildCount()>1)
			return new Oppose(ctx.getChild(0).toString(), ctx.getChild(dernier).accept(this), ctx.getStart().getLine());
		else
			return ctx.getChild(dernier).accept(this);
	} // peut-être qu'on aura besoin de distinguer le cas ! et -, et faire une classe Oppose
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitFleche(grammaireParser.FlecheContext ctx) {
		Ast noeudTemporaire = new Idf(ctx.getChild(0).toString(), ctx.getStart().getLine());
		for (int i=1; 2*i<ctx.getChildCount(); i++) {
			// Ast right = ctx.getChild(2*(i+1)).accept(this);
			String idfString = ctx.getChild(2*i).toString();
			noeudTemporaire = new Fleche(noeudTemporaire, new Idf(idfString, ctx.getStart().getLine()), ctx.getStart().getLine());
		}
		return noeudTemporaire;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitInteger(grammaireParser.IntegerContext ctx) {
		String str = ctx.getChild(0).toString();
		int integer;
		if (str.charAt(0) == '\'')
			integer = (int) str.charAt(str.length()-2);
		else
			integer = Integer.parseInt(str);
		return new Entier(integer, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitIdentifier(grammaireParser.IdentifierContext ctx) {
		String idf = ctx.getChild(0).toString();
		return new Idf(idf, ctx.getStart().getLine());
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
		String idfString = ctx.getChild(0).toString();
		Idf idf = new Idf(idfString, ctx.getStart().getLine());
		ArrayList<Ast> list= new ArrayList<>();

		for(int i=2;i<ctx.getChildCount()-1;i=i+2){
			list.add(ctx.getChild(i).accept(this));
		}
		return new Function(idf, list, ctx.getStart().getLine());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Ast visitSizeof(grammaireParser.SizeofContext ctx) {
		return new Sizeof(new Idf(ctx.getChild(3).toString(), ctx.getStart().getLine()), ctx.getStart().getLine());
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
