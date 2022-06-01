package tomclesius.sdk.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class HdlColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", HdlSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Comments//Line comment", HdlSyntaxHighlighter.LINE_COMMENT),
            new AttributesDescriptor("Comments//Doc comment", HdlSyntaxHighlighter.DOC_COMMENT),
            new AttributesDescriptor("Variable", HdlSyntaxHighlighter.VARIABLE),
            new AttributesDescriptor("Separator", HdlSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Braces and Operators//Comma", HdlSyntaxHighlighter.COMMA),
            new AttributesDescriptor("Braces and Operators//Semicolon", HdlSyntaxHighlighter.SEMICOLON),
            new AttributesDescriptor("Bad value", HdlSyntaxHighlighter.BAD_CHARACTER),
            new AttributesDescriptor("Boolean", HdlSyntaxHighlighter.BOOLEAN),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return HdlIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new HdlSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return  "// This is a Hdl file example\n"+
                "// You can write single line comments with //\n"+
                "// You can write multiline comments with /** */\n"+
                "/**\n\t"+
                    "Nand gate:\n\t"+
                    "out = 1 if (a == 0 and b == 0)\n\t"+
                    "0 otherwise\n"+
                 "*/\n\n"+
                "CHIP Nand {\n\t"+
                    "IN a, b;\n\t"+
                    "OUT out;\n\n\t"+
                    "PARTS:\n\t"+
                    "Nand(a=a,b=b,out=out);\n"+
                "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Hdl";
    }

}