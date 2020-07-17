package com.example.demo.algorithm;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // TODO Auto-generated method stub
        return new String[]{"com.example.demo.algorithm.MathDemo","com.example.demo.algorithm.Human"};
    }
    
}