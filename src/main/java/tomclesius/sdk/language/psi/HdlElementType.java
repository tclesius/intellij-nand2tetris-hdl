package tomclesius.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import tomclesius.sdk.language.HdlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HdlElementType extends IElementType {

    public HdlElementType(@NotNull @NonNls String debugName) {
        super(debugName, HdlLanguage.INSTANCE);
    }

}
