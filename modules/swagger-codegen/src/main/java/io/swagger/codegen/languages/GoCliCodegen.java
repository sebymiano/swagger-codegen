package io.swagger.codegen.languages;


import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.DefaultCodegen;

public class GoCliCodegen extends DefaultCodegen implements CodegenConfig{
    @Override
    public CodegenType getTag() {
        return CodegenType.OTHER;
    }

    @Override
    public String getName() {
        return "go-cli";
    }

    @Override
    public String getHelp() {
        return "Generates a Go CLI library (beta).";
    }
}
