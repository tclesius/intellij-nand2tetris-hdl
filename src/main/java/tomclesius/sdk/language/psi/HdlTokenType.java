package tomclesius.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import tomclesius.sdk.language.HdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HdlTokenType extends IElementType {

    public HdlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, HdlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "HdlTokenType." + super.toString();
    }

}