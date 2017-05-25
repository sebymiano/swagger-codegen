package io.swagger.codegen.languages;


import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.DefaultCodegen;

public class CppRestServerCodegen extends DefaultCodegen implements CodegenConfig {
    @Override
    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    @Override
    public String getName() {
        return "cpprest-server";
    }

    @Override
    public String getHelp() {
        return "Generates a C++ API server.";
    }

    public CppRestServerCodegen() {
        super();
    }
}
