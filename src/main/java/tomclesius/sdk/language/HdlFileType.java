package tomclesius.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class HdlFileType extends LanguageFileType {

    public static final HdlFileType INSTANCE = new HdlFileType();

    private HdlFileType() {
        super(HdlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "HDL";
    }

    @NotNull
    @Override
    public String getDescription() {
        //TODO write a Description
        return "";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "hdl";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return HdlIcons.FILE;
    }

}
