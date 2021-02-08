package com.zcg.jooq.learn;


import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;
import org.jooq.meta.TableDefinition;

/**
 * @Author 周春桂
 * @Date 2020/10/16 15:09
 * @Desciption
 **/
public class CustomGeneratorStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        String result = super.getJavaClassName(definition, mode);
        switch (mode) {
            case POJO:
                result +="Pojo";
                break;
            case DEFAULT:
                if (definition instanceof TableDefinition) {
                    result = "T" + result;
                }
                break;
            default:
                break;
        }
        return result;
    }
}
