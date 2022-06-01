package tomclesius.sdk.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import tomclesius.sdk.language.psi.HdlNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class HdlNamedElementImpl extends ASTWrapperPsiElement implements HdlNamedElement {

    public HdlNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
