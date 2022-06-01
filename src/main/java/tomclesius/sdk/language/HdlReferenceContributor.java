package tomclesius.sdk.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import tomclesius.sdk.language.psi.HdlChip;
import tomclesius.sdk.language.psi.HdlTypes;


public class HdlReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {

    }
}
