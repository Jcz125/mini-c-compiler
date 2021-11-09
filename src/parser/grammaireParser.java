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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, INTEGER=29, IDF=30, COMMENTERS=31, 
		WS=32;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_decl_typ = 2, RULE_decl_vars = 3, 
		RULE_decl_fct = 4, RULE_params = 5, RULE_param = 6, RULE_bloc = 7, RULE_instruction = 8, 
		RULE_if_instruction = 9, RULE_while_instruction = 10, RULE_affect = 11, 
		RULE_expr = 12, RULE_or_op = 13, RULE_et_op = 14, RULE_egalite = 15, RULE_comparaison = 16, 
		RULE_somme = 17, RULE_produit = 18, RULE_oppose = 19, RULE_fleche = 20, 
		RULE_value = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl", "decl_typ", "decl_vars", "decl_fct", "params", "param", 
			"bloc", "instruction", "if_instruction", "while_instruction", "affect", 
			"expr", "or_op", "et_op", "egalite", "comparaison", "somme", "produit", 
			"oppose", "fleche", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "';'", "'int'", "','", "'*'", "'('", 
			"')'", "'return'", "'if'", "'else'", "'while'", "'='", "'||'", "'&&'", 
			"'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'+'", "'-'", "'/'", "'!'", 
			"'->'", "'sizeof'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "INTEGER", "IDF", "COMMENTERS", "WS"
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__4) {
				{
				{
				setState(44);
				decl();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				decl_typ();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
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
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
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
			setState(56);
			match(T__0);
			setState(57);
			match(IDF);
			setState(58);
			match(T__1);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__4) {
				{
				{
				setState(59);
				decl_vars();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(T__2);
			setState(66);
			match(T__3);
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
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public IntDeclContext(Decl_varsContext ctx) { copyFrom(ctx); }
	}
	public static class StructDeclContext extends Decl_varsContext {
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public StructDeclContext(Decl_varsContext ctx) { copyFrom(ctx); }
	}

	public final Decl_varsContext decl_vars() throws RecognitionException {
		Decl_varsContext _localctx = new Decl_varsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl_vars);
		try {
			int _alt;
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new IntDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(T__4);
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(69);
						match(IDF);
						setState(70);
						match(T__5);
						}
						} 
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(76);
				match(IDF);
				setState(77);
				match(T__3);
				}
				break;
			case T__0:
				_localctx = new StructDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				match(T__0);
				setState(79);
				match(IDF);
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(80);
						match(T__6);
						setState(81);
						match(IDF);
						setState(82);
						match(T__5);
						}
						} 
					}
					setState(87);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				{
				setState(88);
				match(T__6);
				setState(89);
				match(IDF);
				}
				setState(91);
				match(T__3);
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
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new IntFctContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(T__4);
				setState(95);
				match(IDF);
				setState(96);
				match(T__7);
				setState(97);
				params();
				setState(98);
				match(T__8);
				setState(99);
				bloc();
				}
				break;
			case T__0:
				_localctx = new StructFctContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(T__0);
				setState(102);
				match(IDF);
				setState(103);
				match(T__6);
				setState(104);
				match(IDF);
				setState(105);
				match(T__7);
				setState(106);
				params();
				setState(107);
				match(T__8);
				setState(108);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			int _alt;
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0 || _la==T__4) {
					{
					setState(112);
					param();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(115);
						param();
						setState(116);
						match(T__5);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(120); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(122);
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
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public StructPointerContext(ParamContext ctx) { copyFrom(ctx); }
	}
	public static class IntParamContext extends ParamContext {
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public IntParamContext(ParamContext ctx) { copyFrom(ctx); }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				_localctx = new IntParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(T__4);
				setState(127);
				match(IDF);
				}
				break;
			case T__0:
				_localctx = new StructPointerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(T__0);
				setState(129);
				match(IDF);
				setState(130);
				match(T__6);
				setState(131);
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
		enterRule(_localctx, 14, RULE_bloc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__1);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__23) | (1L << T__25) | (1L << T__27) | (1L << INTEGER) | (1L << IDF))) != 0)) {
				{
				setState(137);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__4:
					{
					setState(135);
					decl_vars();
					}
					break;
				case T__1:
				case T__3:
				case T__7:
				case T__9:
				case T__10:
				case T__12:
				case T__23:
				case T__25:
				case T__27:
				case INTEGER:
				case IDF:
					{
					setState(136);
					instruction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__2);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class ExpressionContext extends InstructionContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class AffectationContext extends InstructionContext {
		public AffectContext affect() {
			return getRuleContext(AffectContext.class,0);
		}
		public AffectationContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class BlocInstContext extends InstructionContext {
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public BlocInstContext(InstructionContext ctx) { copyFrom(ctx); }
	}
	public static class NoneContext extends InstructionContext {
		public NoneContext(InstructionContext ctx) { copyFrom(ctx); }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instruction);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new NoneContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new ExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				expr();
				setState(146);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new AffectationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				affect();
				setState(149);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new IfInstContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				if_instruction();
				}
				break;
			case 5:
				_localctx = new WhileInstContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				while_instruction();
				}
				break;
			case 6:
				_localctx = new BlocInstContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(153);
				bloc();
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(154);
				match(T__9);
				setState(155);
				expr();
				setState(156);
				match(T__3);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public IfThenElseContext(If_instructionContext ctx) { copyFrom(ctx); }
	}
	public static class IfThenContext extends If_instructionContext {
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
		enterRule(_localctx, 18, RULE_if_instruction);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new IfThenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(T__10);
				setState(161);
				match(T__7);
				setState(162);
				expr();
				setState(163);
				match(T__8);
				setState(164);
				instruction();
				}
				break;
			case 2:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(T__10);
				setState(167);
				match(T__7);
				setState(168);
				expr();
				setState(169);
				match(T__8);
				setState(170);
				instruction();
				setState(171);
				match(T__11);
				setState(172);
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
		enterRule(_localctx, 20, RULE_while_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__12);
			setState(177);
			match(T__7);
			setState(178);
			expr();
			setState(179);
			match(T__8);
			setState(180);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public FlecheContext fleche() {
			return getRuleContext(FlecheContext.class,0);
		}
		public AffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_affect; }
	}

	public final AffectContext affect() throws RecognitionException {
		AffectContext _localctx = new AffectContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_affect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(182);
				match(IDF);
				}
				break;
			case 2:
				{
				setState(183);
				fleche();
				}
				break;
			}
			setState(186);
			match(T__13);
			setState(187);
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
		enterRule(_localctx, 24, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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
		enterRule(_localctx, 26, RULE_or_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			et_op();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(192);
				match(T__14);
				setState(193);
				et_op();
				}
				}
				setState(198);
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
		enterRule(_localctx, 28, RULE_et_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			egalite();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(200);
				match(T__15);
				setState(201);
				egalite();
				}
				}
				setState(206);
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
		enterRule(_localctx, 30, RULE_egalite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			comparaison();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16 || _la==T__17) {
				{
				{
				setState(208);
				_la = _input.LA(1);
				if ( !(_la==T__16 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(209);
				comparaison();
				}
				}
				setState(214);
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
		enterRule(_localctx, 32, RULE_comparaison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			somme();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) {
				{
				{
				setState(216);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
				somme();
				}
				}
				setState(222);
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
		enterRule(_localctx, 34, RULE_somme);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			produit();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22 || _la==T__23) {
				{
				{
				setState(224);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__23) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(225);
				produit();
				}
				}
				setState(230);
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
		enterRule(_localctx, 36, RULE_produit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			oppose();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__24) {
				{
				{
				setState(232);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(233);
				oppose();
				}
				}
				setState(238);
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
		enterRule(_localctx, 38, RULE_oppose);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23 || _la==T__25) {
				{
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(242);
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

	public static class FlecheContext extends ParserRuleContext {
		public List<TerminalNode> IDF() { return getTokens(grammaireParser.IDF); }
		public TerminalNode IDF(int i) {
			return getToken(grammaireParser.IDF, i);
		}
		public FlecheContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fleche; }
	}

	public final FlecheContext fleche() throws RecognitionException {
		FlecheContext _localctx = new FlecheContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_fleche);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(IDF);
			setState(245);
			match(T__26);
			setState(246);
			match(IDF);
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
		public FlecheContext fleche() {
			return getRuleContext(FlecheContext.class,0);
		}
		public ArrowContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionContext extends ValueContext {
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
		public TerminalNode IDF() { return getToken(grammaireParser.IDF, 0); }
		public SizeofContext(ValueContext ctx) { copyFrom(ctx); }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_value);
		int _la;
		try {
			int _alt;
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(IDF);
				}
				break;
			case 3:
				_localctx = new ArrowContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				fleche();
				}
				break;
			case 4:
				_localctx = new FunctionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(251);
				match(IDF);
				setState(252);
				match(T__7);
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__23) | (1L << T__25) | (1L << T__27) | (1L << INTEGER) | (1L << IDF))) != 0)) {
					{
					setState(258);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(253);
							expr();
							setState(254);
							match(T__5);
							}
							} 
						}
						setState(260);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
					}
					setState(261);
					expr();
					}
				}

				setState(264);
				match(T__8);
				}
				break;
			case 5:
				_localctx = new SizeofContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				match(T__27);
				setState(266);
				match(T__7);
				setState(267);
				match(T__0);
				setState(268);
				match(IDF);
				setState(269);
				match(T__8);
				}
				break;
			case 6:
				_localctx = new ParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(270);
				match(T__7);
				setState(271);
				expr();
				setState(272);
				match(T__8);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\7\2\60\n\2\f\2"+
		"\16\2\63\13\2\3\2\3\2\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16"+
		"\4B\13\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5V\n\5\f\5\16\5Y\13\5\3\5\3\5\3\5\3\5\5\5_\n\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3"+
		"\7\5\7t\n\7\3\7\3\7\3\7\6\7y\n\7\r\7\16\7z\3\7\3\7\5\7\177\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u0087\n\b\3\t\3\t\3\t\7\t\u008c\n\t\f\t\16\t\u008f"+
		"\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00a1\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00b1\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5\r\u00bb"+
		"\n\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\7\17\u00c5\n\17\f\17\16\17\u00c8"+
		"\13\17\3\20\3\20\3\20\7\20\u00cd\n\20\f\20\16\20\u00d0\13\20\3\21\3\21"+
		"\3\21\7\21\u00d5\n\21\f\21\16\21\u00d8\13\21\3\22\3\22\3\22\7\22\u00dd"+
		"\n\22\f\22\16\22\u00e0\13\22\3\23\3\23\3\23\7\23\u00e5\n\23\f\23\16\23"+
		"\u00e8\13\23\3\24\3\24\3\24\7\24\u00ed\n\24\f\24\16\24\u00f0\13\24\3\25"+
		"\5\25\u00f3\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\7\27\u0103\n\27\f\27\16\27\u0106\13\27\3\27\5\27\u0109"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0115\n\27"+
		"\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\7\3\2\23"+
		"\24\3\2\25\30\3\2\31\32\4\2\t\t\33\33\4\2\32\32\34\34\2\u0123\2\61\3\2"+
		"\2\2\48\3\2\2\2\6:\3\2\2\2\b^\3\2\2\2\np\3\2\2\2\f~\3\2\2\2\16\u0086\3"+
		"\2\2\2\20\u0088\3\2\2\2\22\u00a0\3\2\2\2\24\u00b0\3\2\2\2\26\u00b2\3\2"+
		"\2\2\30\u00ba\3\2\2\2\32\u00bf\3\2\2\2\34\u00c1\3\2\2\2\36\u00c9\3\2\2"+
		"\2 \u00d1\3\2\2\2\"\u00d9\3\2\2\2$\u00e1\3\2\2\2&\u00e9\3\2\2\2(\u00f2"+
		"\3\2\2\2*\u00f6\3\2\2\2,\u0114\3\2\2\2.\60\5\4\3\2/.\3\2\2\2\60\63\3\2"+
		"\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\2\2"+
		"\3\65\3\3\2\2\2\669\5\6\4\2\679\5\n\6\28\66\3\2\2\28\67\3\2\2\29\5\3\2"+
		"\2\2:;\7\3\2\2;<\7 \2\2<@\7\4\2\2=?\5\b\5\2>=\3\2\2\2?B\3\2\2\2@>\3\2"+
		"\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7\5\2\2DE\7\6\2\2E\7\3\2\2\2FK\7"+
		"\7\2\2GH\7 \2\2HJ\7\b\2\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3"+
		"\2\2\2MK\3\2\2\2NO\7 \2\2O_\7\6\2\2PQ\7\3\2\2QW\7 \2\2RS\7\t\2\2ST\7 "+
		"\2\2TV\7\b\2\2UR\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2"+
		"\2\2Z[\7\t\2\2[\\\7 \2\2\\]\3\2\2\2]_\7\6\2\2^F\3\2\2\2^P\3\2\2\2_\t\3"+
		"\2\2\2`a\7\7\2\2ab\7 \2\2bc\7\n\2\2cd\5\f\7\2de\7\13\2\2ef\5\20\t\2fq"+
		"\3\2\2\2gh\7\3\2\2hi\7 \2\2ij\7\t\2\2jk\7 \2\2kl\7\n\2\2lm\5\f\7\2mn\7"+
		"\13\2\2no\5\20\t\2oq\3\2\2\2p`\3\2\2\2pg\3\2\2\2q\13\3\2\2\2rt\5\16\b"+
		"\2sr\3\2\2\2st\3\2\2\2t\177\3\2\2\2uv\5\16\b\2vw\7\b\2\2wy\3\2\2\2xu\3"+
		"\2\2\2yz\3\2\2\2zx\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\5\16\b\2}\177\3\2\2\2"+
		"~s\3\2\2\2~x\3\2\2\2\177\r\3\2\2\2\u0080\u0081\7\7\2\2\u0081\u0087\7 "+
		"\2\2\u0082\u0083\7\3\2\2\u0083\u0084\7 \2\2\u0084\u0085\7\t\2\2\u0085"+
		"\u0087\7 \2\2\u0086\u0080\3\2\2\2\u0086\u0082\3\2\2\2\u0087\17\3\2\2\2"+
		"\u0088\u008d\7\4\2\2\u0089\u008c\5\b\5\2\u008a\u008c\5\22\n\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\5"+
		"\2\2\u0091\21\3\2\2\2\u0092\u00a1\7\6\2\2\u0093\u0094\5\32\16\2\u0094"+
		"\u0095\7\6\2\2\u0095\u00a1\3\2\2\2\u0096\u0097\5\30\r\2\u0097\u0098\7"+
		"\6\2\2\u0098\u00a1\3\2\2\2\u0099\u00a1\5\24\13\2\u009a\u00a1\5\26\f\2"+
		"\u009b\u00a1\5\20\t\2\u009c\u009d\7\f\2\2\u009d\u009e\5\32\16\2\u009e"+
		"\u009f\7\6\2\2\u009f\u00a1\3\2\2\2\u00a0\u0092\3\2\2\2\u00a0\u0093\3\2"+
		"\2\2\u00a0\u0096\3\2\2\2\u00a0\u0099\3\2\2\2\u00a0\u009a\3\2\2\2\u00a0"+
		"\u009b\3\2\2\2\u00a0\u009c\3\2\2\2\u00a1\23\3\2\2\2\u00a2\u00a3\7\r\2"+
		"\2\u00a3\u00a4\7\n\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00a6\7\13\2\2\u00a6"+
		"\u00a7\5\22\n\2\u00a7\u00b1\3\2\2\2\u00a8\u00a9\7\r\2\2\u00a9\u00aa\7"+
		"\n\2\2\u00aa\u00ab\5\32\16\2\u00ab\u00ac\7\13\2\2\u00ac\u00ad\5\22\n\2"+
		"\u00ad\u00ae\7\16\2\2\u00ae\u00af\5\22\n\2\u00af\u00b1\3\2\2\2\u00b0\u00a2"+
		"\3\2\2\2\u00b0\u00a8\3\2\2\2\u00b1\25\3\2\2\2\u00b2\u00b3\7\17\2\2\u00b3"+
		"\u00b4\7\n\2\2\u00b4\u00b5\5\32\16\2\u00b5\u00b6\7\13\2\2\u00b6\u00b7"+
		"\5\22\n\2\u00b7\27\3\2\2\2\u00b8\u00bb\7 \2\2\u00b9\u00bb\5*\26\2\u00ba"+
		"\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\7\20"+
		"\2\2\u00bd\u00be\5\32\16\2\u00be\31\3\2\2\2\u00bf\u00c0\5\34\17\2\u00c0"+
		"\33\3\2\2\2\u00c1\u00c6\5\36\20\2\u00c2\u00c3\7\21\2\2\u00c3\u00c5\5\36"+
		"\20\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\35\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ce\5 \21"+
		"\2\u00ca\u00cb\7\22\2\2\u00cb\u00cd\5 \21\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\37\3\2\2"+
		"\2\u00d0\u00ce\3\2\2\2\u00d1\u00d6\5\"\22\2\u00d2\u00d3\t\2\2\2\u00d3"+
		"\u00d5\5\"\22\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3"+
		"\2\2\2\u00d6\u00d7\3\2\2\2\u00d7!\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00de"+
		"\5$\23\2\u00da\u00db\t\3\2\2\u00db\u00dd\5$\23\2\u00dc\u00da\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df#\3\2\2\2"+
		"\u00e0\u00de\3\2\2\2\u00e1\u00e6\5&\24\2\u00e2\u00e3\t\4\2\2\u00e3\u00e5"+
		"\5&\24\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7%\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ee\5(\25\2"+
		"\u00ea\u00eb\t\5\2\2\u00eb\u00ed\5(\25\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\'\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f3\t\6\2\2\u00f2\u00f1\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\5,\27\2\u00f5)\3\2\2\2\u00f6\u00f7"+
		"\7 \2\2\u00f7\u00f8\7\35\2\2\u00f8\u00f9\7 \2\2\u00f9+\3\2\2\2\u00fa\u0115"+
		"\7\37\2\2\u00fb\u0115\7 \2\2\u00fc\u0115\5*\26\2\u00fd\u00fe\7 \2\2\u00fe"+
		"\u0108\7\n\2\2\u00ff\u0100\5\32\16\2\u0100\u0101\7\b\2\2\u0101\u0103\3"+
		"\2\2\2\u0102\u00ff\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0109\5\32"+
		"\16\2\u0108\u0104\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u0115\7\13\2\2\u010b\u010c\7\36\2\2\u010c\u010d\7\n\2\2\u010d\u010e\7"+
		"\3\2\2\u010e\u010f\7 \2\2\u010f\u0115\7\13\2\2\u0110\u0111\7\n\2\2\u0111"+
		"\u0112\5\32\16\2\u0112\u0113\7\13\2\2\u0113\u0115\3\2\2\2\u0114\u00fa"+
		"\3\2\2\2\u0114\u00fb\3\2\2\2\u0114\u00fc\3\2\2\2\u0114\u00fd\3\2\2\2\u0114"+
		"\u010b\3\2\2\2\u0114\u0110\3\2\2\2\u0115-\3\2\2\2\34\618@KW^psz~\u0086"+
		"\u008b\u008d\u00a0\u00b0\u00ba\u00c6\u00ce\u00d6\u00de\u00e6\u00ee\u00f2"+
		"\u0104\u0108\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}