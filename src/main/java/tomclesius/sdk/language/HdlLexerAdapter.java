package tomclesius.sdk.language;

import com.intellij.lexer.FlexAdapter;

public class HdlLexerAdapter extends FlexAdapter {

    public HdlLexerAdapter() {
        super(new HdlLexer(null));
    }
}