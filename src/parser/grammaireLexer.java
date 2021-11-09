// Generated from grammaire.g4 by ANTLR 4.9.2

package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammaireLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "INTEGER", "IDF", "CHARACTERS", "SEMICOLON", "COMMA", 
			"INT", "IF", "ELSE", "WHILE", "STRUCT", "RETURN", "SIZEOF", "COMMENTERS", 
			"WS"
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


	public grammaireLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "grammaire.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00d3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\7\25v\n\25\f\25\16\25y\13\25\3\25\3\25\3\25\5\25~\n\25"+
		"\3\26\3\26\7\26\u0082\n\26\f\26\16\26\u0085\13\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\7!\u00b8"+
		"\n!\f!\16!\u00bb\13!\3!\3!\3!\3!\3!\3!\7!\u00c3\n!\f!\16!\u00c6\13!\3"+
		"!\5!\u00c9\n!\3!\3!\3\"\6\"\u00ce\n\"\r\"\16\"\u00cf\3\"\3\"\2\2#\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#\3\2\b\3\2\"\u0080\4\2C\\c|\6\2\62;C\\aac|\3\2\2\u0080\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\2\u00da\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\3E\3\2\2\2\5G\3\2\2\2\7I\3\2\2\2\tK\3\2\2\2\13M\3\2\2\2\rO\3"+
		"\2\2\2\17Q\3\2\2\2\21T\3\2\2\2\23W\3\2\2\2\25Z\3\2\2\2\27]\3\2\2\2\31"+
		"_\3\2\2\2\33b\3\2\2\2\35d\3\2\2\2\37g\3\2\2\2!i\3\2\2\2#k\3\2\2\2%m\3"+
		"\2\2\2\'o\3\2\2\2)}\3\2\2\2+\177\3\2\2\2-\u0086\3\2\2\2/\u0088\3\2\2\2"+
		"\61\u008a\3\2\2\2\63\u008c\3\2\2\2\65\u0090\3\2\2\2\67\u0093\3\2\2\29"+
		"\u0098\3\2\2\2;\u009e\3\2\2\2=\u00a5\3\2\2\2?\u00ac\3\2\2\2A\u00c8\3\2"+
		"\2\2C\u00cd\3\2\2\2EF\7}\2\2F\4\3\2\2\2GH\7\177\2\2H\6\3\2\2\2IJ\7,\2"+
		"\2J\b\3\2\2\2KL\7*\2\2L\n\3\2\2\2MN\7+\2\2N\f\3\2\2\2OP\7?\2\2P\16\3\2"+
		"\2\2QR\7~\2\2RS\7~\2\2S\20\3\2\2\2TU\7(\2\2UV\7(\2\2V\22\3\2\2\2WX\7?"+
		"\2\2XY\7?\2\2Y\24\3\2\2\2Z[\7#\2\2[\\\7?\2\2\\\26\3\2\2\2]^\7>\2\2^\30"+
		"\3\2\2\2_`\7>\2\2`a\7?\2\2a\32\3\2\2\2bc\7@\2\2c\34\3\2\2\2de\7@\2\2e"+
		"f\7?\2\2f\36\3\2\2\2gh\7-\2\2h \3\2\2\2ij\7/\2\2j\"\3\2\2\2kl\7\61\2\2"+
		"l$\3\2\2\2mn\7#\2\2n&\3\2\2\2op\7/\2\2pq\7@\2\2q(\3\2\2\2r~\7\62\2\2s"+
		"w\4\63;\2tv\4\62;\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x~\3\2\2\2"+
		"yw\3\2\2\2z{\7)\2\2{|\t\2\2\2|~\7)\2\2}r\3\2\2\2}s\3\2\2\2}z\3\2\2\2~"+
		"*\3\2\2\2\177\u0083\t\3\2\2\u0080\u0082\t\4\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084,\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0086\u0087\t\2\2\2\u0087.\3\2\2\2\u0088\u0089\7"+
		"=\2\2\u0089\60\3\2\2\2\u008a\u008b\7.\2\2\u008b\62\3\2\2\2\u008c\u008d"+
		"\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f\64\3\2\2\2\u0090\u0091"+
		"\7k\2\2\u0091\u0092\7h\2\2\u0092\66\3\2\2\2\u0093\u0094\7g\2\2\u0094\u0095"+
		"\7n\2\2\u0095\u0096\7u\2\2\u0096\u0097\7g\2\2\u00978\3\2\2\2\u0098\u0099"+
		"\7y\2\2\u0099\u009a\7j\2\2\u009a\u009b\7k\2\2\u009b\u009c\7n\2\2\u009c"+
		"\u009d\7g\2\2\u009d:\3\2\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7v\2\2\u00a0"+
		"\u00a1\7t\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7v\2\2"+
		"\u00a4<\3\2\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7v\2"+
		"\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7p\2\2\u00ab>\3\2"+
		"\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7|\2\2\u00af\u00b0"+
		"\7g\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7h\2\2\u00b2@\3\2\2\2\u00b3\u00b4"+
		"\7\61\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b9\3\2\2\2\u00b6\u00b8\t\5\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7,\2\2\u00bd"+
		"\u00c9\7\61\2\2\u00be\u00bf\7\61\2\2\u00bf\u00c0\7\61\2\2\u00c0\u00c4"+
		"\3\2\2\2\u00c1\u00c3\t\5\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00c9\t\6\2\2\u00c8\u00b3\3\2\2\2\u00c8\u00be\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\b!\2\2\u00cbB\3\2\2\2\u00cc\u00ce\t\7\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b\"\2\2\u00d2D\3\2\2\2\n\2w}\u0083"+
		"\u00b9\u00c4\u00c8\u00cf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}