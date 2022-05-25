package tomclesius.sdk.language;

import com.intellij.lang.Language;

public class HdlLanguage extends Language {
    public static final HdlLanguage INSTANCE = new HdlLanguage();

    private HdlLanguage() {
        super("HDL");
    }
}
