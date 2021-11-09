// Generated from grammaire.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammaireParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, INTEGER=20, IDF=21, CHARACTERS=22, SEMICOLON=23, COMMA=24, 
		INT=25, IF=26, ELSE=27, WHILE=28, STRUCT=29, RETURN=30, SIZEOF=31, COMMENTERS=32, 
		WS=33;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_decl_typ = 2, RULE_decl_vars = 3, 
		RULE_decl_fct = 4, RULE_param = 5, RULE_bloc = 6, RULE_instruction = 7, 
		RULE_if_instruction = 8, RULE_while_instruction = 9, RULE_affect = 10, 
		RULE_expr = 11, RULE_or_op = 12, RULE_et_op = 13, RULE_egalite = 14, RULE_comparaison = 15, 
		RULE_somme = 16, RULE_produit = 17, RULE_oppose = 18, RULE_value = 19, 
		RULE_params = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl", "decl_typ", "decl_vars", "decl_fct", "param", "bloc", 
			"instruction", "if_instruction", "while_instruction", "affect", "expr", 
			"or_op", "et_op", "egalite", "comparaison", "somme", "produit", "oppose", 
			"value", "params"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'*'", "'('", "')'", "'='", "'||'", "'&&'", "'=='", 
			"'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'/'", "'!'", "'->'", 
			null, null, null, "';'", "','", "'int'", "'if'", "'else'", "'while'", 
			"'struct'", "'return'", "'sizeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "INTEGER", "IDF", "CHARACTERS", 
			"SEMICOLON", "COMMA", "INT", "IF", "ELSE", "WHILE", "STRUCT", "RETURN", 
			"SIZEOF", "COMMENTERS", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "grammaire.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public grammaireParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(grammaireParser.EOF, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==STRUCT) {
				{
				{
				setState(42);
				decl();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Decl_typContext decl_typ() {
			return getRuleContext(Decl_typContext.class,0);
		}
		public Decl_fctContext decl_fct() {
			return getRuleContext(Decl_fctContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				decl_typ();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				decl_fct();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_typContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(grammaireParser.STRUCT, 0); }
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public TerminalNode SEMICOLON() { return getToken(grammaireParser.SEMICOLON, 0); }
		public List<Decl_varsContext> decl_vars() {
			return getRuleContexts(Decl_varsContext.class);
		}
		public Decl_varsContext decl_vars(int i) {
			return getRuleContext(Decl_varsContext.class,i);
		}
		public Decl_typContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_typ; }
	}

	public final Decl_typContext decl_typ() throws RecognitionException {
		Decl_typContext _localctx = new Decl_typContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_typ);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(STRUCT);
			setState(55);
			match(IDF);
			setState(56);
			match(T__0);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==STRUCT) {
				{
				{
				setState(57);
				decl_vars();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			match(T__1);
			setState(64);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_varsContext extends ParserRuleContext {
		public Decl_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_vars; }
	 
		public Decl_varsContext() { }
		public void copyFrom(Decl_varsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntDeclContext extends Decl_varsContext {
		public TerminalNode INT() { return getToken(grammaireParser.INT, 0); }
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public TerminalNode SEMICOLON() { return getToken(grammaireParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(grammaireParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(grammaireParser.COMMA, i);
		}
		public IntDeclContext(Decl_varsContext ctx) { copyFrom(ctx); }
	}
	public static class StructDeclContext extends Decl_varsContext {
		public TerminalNode STRUCT() { return getToken(grammaireParser.STRUCT, 0); }
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public TerminalNode SEMICOLON() { return getToken(grammaireParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(grammaireParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(grammaireParser.COMMA, i);
		}
		public StructDeclContext(Decl_varsContext ctx) { copyFrom(ctx); }
	}

	public final Decl_varsContext decl_vars() throws RecognitionException {
		Decl_varsContext _localctx = new Decl_varsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl_vars);
		try {
			int _alt;
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(INT);
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(67);
						match(IDF);
						setState(68);
						match(COMMA);
						}
						} 
					}
					setState(73);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(74);
				match(IDF);
				setState(75);
				match(SEMICOLON);
				}
				break;
			case STRUCT:
				_localctx = new StructDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(STRUCT);
				setState(77);
				match(IDF);
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						match(T__2);
						setState(79);
						match(IDF);
						setState(80);
						match(COMMA);
						}
						} 
					}
					setState(85);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				{
				setState(86);
				match(T__2);
				setState(87);
				match(IDF);
				}
				setState(89);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_fctContext extends ParserRuleContext {
		public Decl_fctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_fct; }
	 
		public Decl_fctContext() { }
		public void copyFrom(Decl_fctContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructFctContext extends Decl_fctContext {
		public TerminalNode STRUCT() { return getToken(grammaireParser.STRUCT, 0); }
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public StructFctContext(Decl_fctContext ctx) { copyFrom(ctx); }
	}
	public static class IntFctContext extends Decl_fctContext {
		public TerminalNode INT() { return getToken(grammaireParser.INT, 0); }
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public IntFctContext(Decl_fctContext ctx) { copyFrom(ctx); }
	}

	public final Decl_fctContext decl_fct() throws RecognitionException {
		Decl_fctContext _localctx = new Decl_fctContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decl_fct);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntFctContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(INT);
				setState(93);
				match(IDF);
				setState(94);
				match(T__3);
				setState(95);
				params();
				setState(96);
				match(T__4);
				setState(97);
				bloc();
				}
				break;
			case STRUCT:
				_localctx = new StructFctContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(STRUCT);
				setState(100);
				match(IDF);
				setState(101);
				match(T__2);
				setState(102);
				match(IDF);
				setState(103);
				match(T__3);
				setState(104);
				params();
				setState(105);
				match(T__4);
				setState(106);
				bloc();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructPointerContext extends ParamContext {
		public TerminalNode STRUCT() { return getToken(grammaireParser.STRUCT, 0); }
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public StructPointerContext(ParamContext ctx) { copyFrom(ctx); }
	}
	public static class IntParamContext extends ParamContext {
		public TerminalNode INT() { return getToken(grammaireParser.INT, 0); }
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public IntParamContext(ParamContext ctx) { copyFrom(ctx); }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(INT);
				setState(111);
				match(IDF);
				}
				break;
			case STRUCT:
				_localctx = new StructPointerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(STRUCT);
				setState(113);
				match(IDF);
				setState(114);
				match(T__2);
				setState(115);
				match(IDF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocContext extends ParserRuleContext {
		public List<Decl_varsContext> decl_vars() {
			return getRuleContexts(Decl_varsContext.class);
		}
		public Decl_varsContext decl_vars(int i) {
			return getRuleContext(Decl_varsContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__0);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT || _la==STRUCT) {
				{
				{
				setState(119);
				decl_vars();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__15) | (1L << T__17) | (1L << INTEGER) | (1L << IDF) | (1L << SEMICOLON) | (1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << SIZEOF))) != 0)) {
				{
				{
				setState(125);
				instruction();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionContext extends ParserRuleContext {
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	 
		public InstructionContext() { }
		public void copyFrom(InstructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhileInstContext extends InstructionContext {
		public While_instructionContext while_instruction() {
			return getRuleContext(While_instructionContext.class,0);
		}
		public WhileInstContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class IfInstContext extends InstructionContext {
		public If_instructionContext if_instruction() {
			return getRuleContext(If_instructionContext.class,0);
		}
		public IfInstContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnContext extends InstructionContext {
		public TerminalNode RETURN() { return getToken(grammaireParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(grammaireParser.SEMICOLON, 0); }
		public ReturnContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class ExpressionContext extends InstructionContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(grammaireParser.SEMICOLON, 0); }
		public ExpressionContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class AffectationContext extends InstructionContext {
		public AffectContext affect() {
			return getRuleContext(AffectContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(grammaireParser.SEMICOLON, 0); }
		public AffectationContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class BlocInstContext extends InstructionContext {
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public BlocInstContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class NoneContext extends InstructionContext {
		public TerminalNode SEMICOLON() { return getToken(grammaireParser.SEMICOLON, 0); }
		public NoneContext(InstructionContext ctx) { copyFrom(ctx); }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instruction);
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				expr();
				setState(135);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new AffectationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				affect();
				setState(138);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new IfInstContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(140);
				if_instruction();
				}
				break;
			case 5:
				_localctx = new WhileInstContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				while_instruction();
				}
				break;
			case 6:
				_localctx = new BlocInstContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(142);
				bloc();
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(143);
				match(RETURN);
				setState(144);
				expr();
				setState(145);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_instructionContext extends ParserRuleContext {
		public If_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_instruction; }
	 
		public If_instructionContext() { }
		public void copyFrom(If_instructionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfThenElseContext extends If_instructionContext {
		public TerminalNode IF() { return getToken(grammaireParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(grammaireParser.ELSE, 0); }
		public IfThenElseContext(If_instructionContext ctx) { copyFrom(ctx); }
	}
	public static class IfThenContext extends If_instructionContext {
		public TerminalNode IF() { return getToken(grammaireParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public IfThenContext(If_instructionContext ctx) { copyFrom(ctx); }
	}

	public final If_instructionContext if_instruction() throws RecognitionException {
		If_instructionContext _localctx = new If_instructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_if_instruction);
		try {
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IfThenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(IF);
				setState(150);
				match(T__3);
				setState(151);
				expr();
				setState(152);
				match(T__4);
				setState(153);
				instruction();
				}
				break;
			case 2:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(IF);
				setState(156);
				match(T__3);
				setState(157);
				expr();
				setState(158);
				match(T__4);
				setState(159);
				instruction();
				setState(160);
				match(ELSE);
				setState(161);
				instruction();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_instructionContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(grammaireParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public While_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_instruction; }
	}

	public final While_instructionContext while_instruction() throws RecognitionException {
		While_instructionContext _localctx = new While_instructionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(WHILE);
			setState(166);
			match(T__3);
			setState(167);
			expr();
			setState(168);
			match(T__4);
			setState(169);
			instruction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AffectContext extends ParserRuleContext {
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affect; }
	}

	public final AffectContext affect() throws RecognitionException {
		AffectContext _localctx = new AffectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_affect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(IDF);
			setState(172);
			match(T__5);
			setState(173);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Or_opContext or_op() {
			return getRuleContext(Or_opContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			or_op();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_opContext extends ParserRuleContext {
		public List<Et_opContext> et_op() {
			return getRuleContexts(Et_opContext.class);
		}
		public Et_opContext et_op(int i) {
			return getRuleContext(Et_opContext.class,i);
		}
		public Or_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_op; }
	}

	public final Or_opContext or_op() throws RecognitionException {
		Or_opContext _localctx = new Or_opContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_or_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			et_op();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(178);
				match(T__6);
				setState(179);
				et_op();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Et_opContext extends ParserRuleContext {
		public List<EgaliteContext> egalite() {
			return getRuleContexts(EgaliteContext.class);
		}
		public EgaliteContext egalite(int i) {
			return getRuleContext(EgaliteContext.class,i);
		}
		public Et_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_et_op; }
	}

	public final Et_opContext et_op() throws RecognitionException {
		Et_opContext _localctx = new Et_opContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_et_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			egalite();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(186);
				match(T__7);
				setState(187);
				egalite();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EgaliteContext extends ParserRuleContext {
		public List<ComparaisonContext> comparaison() {
			return getRuleContexts(ComparaisonContext.class);
		}
		public ComparaisonContext comparaison(int i) {
			return getRuleContext(ComparaisonContext.class,i);
		}
		public EgaliteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_egalite; }
	}

	public final EgaliteContext egalite() throws RecognitionException {
		EgaliteContext _localctx = new EgaliteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_egalite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			comparaison();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==T__9) {
				{
				{
				setState(194);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==T__9) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(195);
				comparaison();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparaisonContext extends ParserRuleContext {
		public List<SommeContext> somme() {
			return getRuleContexts(SommeContext.class);
		}
		public SommeContext somme(int i) {
			return getRuleContext(SommeContext.class,i);
		}
		public ComparaisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparaison; }
	}

	public final ComparaisonContext comparaison() throws RecognitionException {
		ComparaisonContext _localctx = new ComparaisonContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparaison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			somme();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				{
				setState(202);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(203);
				somme();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SommeContext extends ParserRuleContext {
		public List<ProduitContext> produit() {
			return getRuleContexts(ProduitContext.class);
		}
		public ProduitContext produit(int i) {
			return getRuleContext(ProduitContext.class,i);
		}
		public SommeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_somme; }
	}

	public final SommeContext somme() throws RecognitionException {
		SommeContext _localctx = new SommeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_somme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			produit();
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14 || _la==T__15) {
				{
				{
				setState(210);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(211);
				produit();
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProduitContext extends ParserRuleContext {
		public List<OpposeContext> oppose() {
			return getRuleContexts(OpposeContext.class);
		}
		public OpposeContext oppose(int i) {
			return getRuleContext(OpposeContext.class,i);
		}
		public ProduitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_produit; }
	}

	public final ProduitContext produit() throws RecognitionException {
		ProduitContext _localctx = new ProduitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_produit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			oppose();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__16) {
				{
				{
				setState(218);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__16) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(219);
				oppose();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpposeContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public OpposeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oppose; }
	}

	public final OpposeContext oppose() throws RecognitionException {
		OpposeContext _localctx = new OpposeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_oppose);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15 || _la==T__17) {
				{
				setState(225);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(228);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerContext extends ValueContext {
		public TerminalNode INTEGER() { return getToken(grammaireParser.INTEGER, 0); }
		public IntegerContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ArrowContext extends ValueContext {
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public ArrowContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionContext extends ValueContext {
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunctionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ParenthesisContext extends ValueContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class IdentifierContext extends ValueContext {
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public IdentifierContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class SizeofContext extends ValueContext {
		public TerminalNode SIZEOF() { return getToken(grammaireParser.SIZEOF, 0); }
		public TerminalNode STRUCT() { return getToken(grammaireParser.STRUCT, 0); }
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public SizeofContext(ValueContext ctx) { copyFrom(ctx); }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_value);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(IDF);
				}
				break;
			case 3:
				_localctx = new ArrowContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				match(IDF);
				setState(233);
				match(T__18);
				setState(234);
				match(IDF);
				}
				break;
			case 4:
				_localctx = new FunctionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				match(IDF);
				setState(236);
				match(T__3);
				setState(237);
				params();
				setState(238);
				match(T__4);
				}
				break;
			case 5:
				_localctx = new SizeofContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				match(SIZEOF);
				setState(241);
				match(T__3);
				setState(242);
				match(STRUCT);
				setState(243);
				match(IDF);
				setState(244);
				match(T__4);
				}
				break;
			case 6:
				_localctx = new ParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(245);
				match(T__3);
				setState(246);
				expr();
				setState(247);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(grammaireParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(grammaireParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_params);
		int _la;
		try {
			int _alt;
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INT || _la==STRUCT) {
					{
					setState(251);
					param();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(254);
						param();
						setState(255);
						match(COMMA);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(259); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(261);
				param();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u010c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2"+
		"\3\2\3\2\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5T\n\5\f\5\16\5W\13\5\3\5\3\5\3\5\3\5\5\5]\n\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7w\n\7\3\b\3\b\7\b{\n\b\f\b\16\b~\13\b\3\b\7\b\u0081\n"+
		"\b\f\b\16\b\u0084\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\u0096\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u00a6\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\7\16\u00b7\n\16\f\16\16\16\u00ba\13\16\3"+
		"\17\3\17\3\17\7\17\u00bf\n\17\f\17\16\17\u00c2\13\17\3\20\3\20\3\20\7"+
		"\20\u00c7\n\20\f\20\16\20\u00ca\13\20\3\21\3\21\3\21\7\21\u00cf\n\21\f"+
		"\21\16\21\u00d2\13\21\3\22\3\22\3\22\7\22\u00d7\n\22\f\22\16\22\u00da"+
		"\13\22\3\23\3\23\3\23\7\23\u00df\n\23\f\23\16\23\u00e2\13\23\3\24\5\24"+
		"\u00e5\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00fc\n\25\3\26\5\26"+
		"\u00ff\n\26\3\26\3\26\3\26\6\26\u0104\n\26\r\26\16\26\u0105\3\26\3\26"+
		"\5\26\u010a\n\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*\2\7\3\2\13\f\3\2\r\20\3\2\21\22\4\2\5\5\23\23\4\2\22\22\24\24\2\u0116"+
		"\2/\3\2\2\2\4\66\3\2\2\2\68\3\2\2\2\b\\\3\2\2\2\nn\3\2\2\2\fv\3\2\2\2"+
		"\16x\3\2\2\2\20\u0095\3\2\2\2\22\u00a5\3\2\2\2\24\u00a7\3\2\2\2\26\u00ad"+
		"\3\2\2\2\30\u00b1\3\2\2\2\32\u00b3\3\2\2\2\34\u00bb\3\2\2\2\36\u00c3\3"+
		"\2\2\2 \u00cb\3\2\2\2\"\u00d3\3\2\2\2$\u00db\3\2\2\2&\u00e4\3\2\2\2(\u00fb"+
		"\3\2\2\2*\u0109\3\2\2\2,.\5\4\3\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\2\2\3\63\3\3\2\2\2\64\67\5"+
		"\6\4\2\65\67\5\n\6\2\66\64\3\2\2\2\66\65\3\2\2\2\67\5\3\2\2\289\7\37\2"+
		"\29:\7\27\2\2:>\7\3\2\2;=\5\b\5\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2"+
		"\2\2?A\3\2\2\2@>\3\2\2\2AB\7\4\2\2BC\7\31\2\2C\7\3\2\2\2DI\7\33\2\2EF"+
		"\7\27\2\2FH\7\32\2\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2"+
		"KI\3\2\2\2LM\7\27\2\2M]\7\31\2\2NO\7\37\2\2OU\7\27\2\2PQ\7\5\2\2QR\7\27"+
		"\2\2RT\7\32\2\2SP\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3"+
		"\2\2\2XY\7\5\2\2YZ\7\27\2\2Z[\3\2\2\2[]\7\31\2\2\\D\3\2\2\2\\N\3\2\2\2"+
		"]\t\3\2\2\2^_\7\33\2\2_`\7\27\2\2`a\7\6\2\2ab\5*\26\2bc\7\7\2\2cd\5\16"+
		"\b\2do\3\2\2\2ef\7\37\2\2fg\7\27\2\2gh\7\5\2\2hi\7\27\2\2ij\7\6\2\2jk"+
		"\5*\26\2kl\7\7\2\2lm\5\16\b\2mo\3\2\2\2n^\3\2\2\2ne\3\2\2\2o\13\3\2\2"+
		"\2pq\7\33\2\2qw\7\27\2\2rs\7\37\2\2st\7\27\2\2tu\7\5\2\2uw\7\27\2\2vp"+
		"\3\2\2\2vr\3\2\2\2w\r\3\2\2\2x|\7\3\2\2y{\5\b\5\2zy\3\2\2\2{~\3\2\2\2"+
		"|z\3\2\2\2|}\3\2\2\2}\u0082\3\2\2\2~|\3\2\2\2\177\u0081\5\20\t\2\u0080"+
		"\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\4\2\2\u0086\17"+
		"\3\2\2\2\u0087\u0096\7\31\2\2\u0088\u0089\5\30\r\2\u0089\u008a\7\31\2"+
		"\2\u008a\u0096\3\2\2\2\u008b\u008c\5\26\f\2\u008c\u008d\7\31\2\2\u008d"+
		"\u0096\3\2\2\2\u008e\u0096\5\22\n\2\u008f\u0096\5\24\13\2\u0090\u0096"+
		"\5\16\b\2\u0091\u0092\7 \2\2\u0092\u0093\5\30\r\2\u0093\u0094\7\31\2\2"+
		"\u0094\u0096\3\2\2\2\u0095\u0087\3\2\2\2\u0095\u0088\3\2\2\2\u0095\u008b"+
		"\3\2\2\2\u0095\u008e\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0090\3\2\2\2\u0095"+
		"\u0091\3\2\2\2\u0096\21\3\2\2\2\u0097\u0098\7\34\2\2\u0098\u0099\7\6\2"+
		"\2\u0099\u009a\5\30\r\2\u009a\u009b\7\7\2\2\u009b\u009c\5\20\t\2\u009c"+
		"\u00a6\3\2\2\2\u009d\u009e\7\34\2\2\u009e\u009f\7\6\2\2\u009f\u00a0\5"+
		"\30\r\2\u00a0\u00a1\7\7\2\2\u00a1\u00a2\5\20\t\2\u00a2\u00a3\7\35\2\2"+
		"\u00a3\u00a4\5\20\t\2\u00a4\u00a6\3\2\2\2\u00a5\u0097\3\2\2\2\u00a5\u009d"+
		"\3\2\2\2\u00a6\23\3\2\2\2\u00a7\u00a8\7\36\2\2\u00a8\u00a9\7\6\2\2\u00a9"+
		"\u00aa\5\30\r\2\u00aa\u00ab\7\7\2\2\u00ab\u00ac\5\20\t\2\u00ac\25\3\2"+
		"\2\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\7\b\2\2\u00af\u00b0\5\30\r\2\u00b0"+
		"\27\3\2\2\2\u00b1\u00b2\5\32\16\2\u00b2\31\3\2\2\2\u00b3\u00b8\5\34\17"+
		"\2\u00b4\u00b5\7\t\2\2\u00b5\u00b7\5\34\17\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\33\3\2\2"+
		"\2\u00ba\u00b8\3\2\2\2\u00bb\u00c0\5\36\20\2\u00bc\u00bd\7\n\2\2\u00bd"+
		"\u00bf\5\36\20\2\u00be\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3"+
		"\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\35\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\u00c8\5 \21\2\u00c4\u00c5\t\2\2\2\u00c5\u00c7\5 \21\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\37\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00d0\5\"\22\2\u00cc\u00cd\t\3\2"+
		"\2\u00cd\u00cf\5\"\22\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1!\3\2\2\2\u00d2\u00d0\3\2\2\2"+
		"\u00d3\u00d8\5$\23\2\u00d4\u00d5\t\4\2\2\u00d5\u00d7\5$\23\2\u00d6\u00d4"+
		"\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"#\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00e0\5&\24\2\u00dc\u00dd\t\5\2\2"+
		"\u00dd\u00df\5&\24\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1%\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e5\t\6\2\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6\u00e7\5(\25\2\u00e7\'\3\2\2\2\u00e8\u00fc\7\26\2\2\u00e9\u00fc"+
		"\7\27\2\2\u00ea\u00eb\7\27\2\2\u00eb\u00ec\7\25\2\2\u00ec\u00fc\7\27\2"+
		"\2\u00ed\u00ee\7\27\2\2\u00ee\u00ef\7\6\2\2\u00ef\u00f0\5*\26\2\u00f0"+
		"\u00f1\7\7\2\2\u00f1\u00fc\3\2\2\2\u00f2\u00f3\7!\2\2\u00f3\u00f4\7\6"+
		"\2\2\u00f4\u00f5\7\37\2\2\u00f5\u00f6\7\27\2\2\u00f6\u00fc\7\7\2\2\u00f7"+
		"\u00f8\7\6\2\2\u00f8\u00f9\5\30\r\2\u00f9\u00fa\7\7\2\2\u00fa\u00fc\3"+
		"\2\2\2\u00fb\u00e8\3\2\2\2\u00fb\u00e9\3\2\2\2\u00fb\u00ea\3\2\2\2\u00fb"+
		"\u00ed\3\2\2\2\u00fb\u00f2\3\2\2\2\u00fb\u00f7\3\2\2\2\u00fc)\3\2\2\2"+
		"\u00fd\u00ff\5\f\7\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u010a"+
		"\3\2\2\2\u0100\u0101\5\f\7\2\u0101\u0102\7\32\2\2\u0102\u0104\3\2\2\2"+
		"\u0103\u0100\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\5\f\7\2\u0108\u010a\3\2\2\2\u0109"+
		"\u00fe\3\2\2\2\u0109\u0103\3\2\2\2\u010a+\3\2\2\2\31/\66>IU\\nv|\u0082"+
		"\u0095\u00a5\u00b8\u00c0\u00c8\u00d0\u00d8\u00e0\u00e4\u00fb\u00fe\u0105"+
		"\u0109";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}