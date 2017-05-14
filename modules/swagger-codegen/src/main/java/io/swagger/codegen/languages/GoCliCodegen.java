package io.swagger.codegen.languages;


import io.swagger.codegen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class GoCliCodegen extends GoClientCodegen {
    static Logger LOGGER = LoggerFactory.getLogger(GoCliCodegen.class);

    protected String packageName = "swagger";
    protected String packageVersion = "1.0.0";

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

    public GoCliCodegen(){
        super();

        outputFolder = "generated-code/go-cli";
        //modelTemplateFiles.put("model.mustache", ".go");
        apiTemplateFiles.put("create.mustache", ".go");

        //modelDocTemplateFiles.put("model_doc.mustache", ".md");
        //apiDocTemplateFiles.put("api_doc.mustache", ".md");

        embeddedTemplateDir = templateDir = "go-cli";

        cliOptions.clear();
        cliOptions.add(new CliOption(CodegenConstants.PACKAGE_NAME, "Go-cli package name (convention: lowercase).")
                .defaultValue("swagger"));
        cliOptions.add(new CliOption(CodegenConstants.PACKAGE_VERSION, "Go-cli package version.")
                .defaultValue("1.0.0"));
        cliOptions.add(new CliOption(CodegenConstants.HIDE_GENERATION_TIMESTAMP, "hides the timestamp when files were generated")
                .defaultValue(Boolean.TRUE.toString()));
    }

    @Override
    public void processOpts() {
        super.processOpts();

        supportingFiles.clear();
    }

    @Override
    public String toApiFilename(String name) {
        // replace - with _ e.g. created-at => created_at
        name = name.replaceAll("-", "_"); // FIXME: a parameter should not be assigned. Also declare the methods parameters as 'final'.

        // e.g. PetApi.go => pet_api.go
        return underscore(name) + "_api";
    }

    @Override
    public String apiDocFileFolder() {
        return (outputFolder + "/" + apiDocPath).replace('/', File.separatorChar);
    }

    @Override
    public String modelDocFileFolder() {
        return (outputFolder + "/" + modelDocPath).replace('/', File.separatorChar);
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPackageVersion(String packageVersion) {
        this.packageVersion = packageVersion;
    }
}
