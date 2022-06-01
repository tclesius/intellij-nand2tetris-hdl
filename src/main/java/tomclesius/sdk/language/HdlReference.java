package tomclesius.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import tomclesius.sdk.language.psi.HdlChip;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tomclesius.sdk.language.psi.impl.HdlUtil;

import java.util.ArrayList;
import java.util.List;

public class HdlReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    public HdlReference(@NotNull PsiElement element, TextRange rangeInElement, boolean soft) {
        super(element, rangeInElement, soft);
    }

    public HdlReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
    }

    public HdlReference(@NotNull PsiElement element, boolean soft) {
        super(element, soft);
    }

    public HdlReference(@NotNull PsiElement element) {
        super(element);
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        return new ResolveResult[0];
    }

    @Override
    public @NotNull TextRange getAbsoluteRange() {
        return super.getAbsoluteRange();
    }

    @Override
    public @Nullable PsiElement resolve() {
        return null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        return super.getVariants();
    }
}
