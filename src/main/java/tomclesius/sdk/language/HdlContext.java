package tomclesius.sdk.language;

import com.intellij.codeInsight.template.TemplateActionContext;
import com.intellij.codeInsight.template.TemplateContextType;
import org.jetbrains.annotations.NotNull;

public class HdlContext extends TemplateContextType {

    protected HdlContext() {
        super("Hdl", "Hdl");
    }

    @Override
    public boolean isInContext(@NotNull TemplateActionContext context) {
        return context.getFile().getName().endsWith(".hdl");
    }
}
