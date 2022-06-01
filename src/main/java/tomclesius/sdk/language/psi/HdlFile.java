package tomclesius.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import tomclesius.sdk.language.HdlFileType;
import tomclesius.sdk.language.HdlLanguage;
import org.jetbrains.annotations.NotNull;

public class HdlFile extends PsiFileBase {

    public HdlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, HdlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return HdlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Hdl";
    }

}