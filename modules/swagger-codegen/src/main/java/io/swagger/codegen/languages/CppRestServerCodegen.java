package io.swagger.codegen.languages;


import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.DefaultCodegen;
import io.swagger.codegen.SupportingFile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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

        apiPackage = "io.swagger.server.api";

        modelTemplateFiles.put("model-header.mustache", ".h");
        modelTemplateFiles.put("model-source.mustache", ".cpp");

        apiTemplateFiles.put("api-header.mustache", ".h");
        apiTemplateFiles.put("api-source.mustache", ".cpp");

        embeddedTemplateDir = templateDir = "cpprest-server";

        cliOptions.clear();

        reservedWords = new HashSet<>();

        supportingFiles.add(new SupportingFile("modelbase-header.mustache", "model", "ModelBase.h"));
        supportingFiles.add(new SupportingFile("modelbase-source.mustache", "model", "ModelBase.cpp"));
        supportingFiles.add(new SupportingFile("restserver-header.mustache", "", "RestServer.h"));
        supportingFiles.add(new SupportingFile("restserver-source.mustache", "", "RestServer.cpp"));


        languageSpecificPrimitives = new HashSet<String>(
                Arrays.asList("int", "char", "bool", "long", "float", "double", "int32_t", "int64_t"));

        typeMapping = new HashMap<String, String>();
        typeMapping.put("date", "utility::datetime");
        typeMapping.put("DateTime", "utility::datetime");
        typeMapping.put("string", "utility::string_t");
        typeMapping.put("integer", "int32_t");
        typeMapping.put("long", "int64_t");
        typeMapping.put("boolean", "bool");
        typeMapping.put("array", "std::vector");
        typeMapping.put("map", "std::map");
        typeMapping.put("file", "HttpContent");
        typeMapping.put("object", "Object");
        typeMapping.put("binary", "std::string");
        typeMapping.put("number", "double");
        typeMapping.put("UUID", "utility::string_t");

        super.importMapping = new HashMap<String, String>();
        importMapping.put("std::vector", "#include <vector>");
        importMapping.put("std::map", "#include <map>");
        importMapping.put("std::string", "#include <string>");
        importMapping.put("HttpContent", "#include \"HttpContent.h\"");
        importMapping.put("Object", "#include \"Object.h\"");
        importMapping.put("utility::string_t", "#include <cpprest/details/basic_types.h>");
        importMapping.put("utility::datetime", "#include <cpprest/details/basic_types.h>");

    }

    /**
     * Location to write model files. You can use the modelPackage() as defined
     * when the class is instantiated
     */
    public String modelFileFolder() {
        return outputFolder + "/model";
    }

    /**
     * Location to write api files. You can use the apiPackage() as defined when
     * the class is instantiated
     */
    @Override
    public String apiFileFolder() {
        return outputFolder;
    }
}
