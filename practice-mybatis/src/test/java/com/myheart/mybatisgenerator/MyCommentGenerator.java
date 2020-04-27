package com.myheart.mybatisgenerator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;
/**
 * @author yangxin
 * @date 2019/9/23
 */
public class MyCommentGenerator extends SimpleCommentGenerator {
    private Properties properties;

    public MyCommentGenerator() {
        properties = new Properties();
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        // 获取自定义的 properties
        this.properties.putAll(properties);
    }

//    @Override
//    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//        String author = properties.getProperty("author");
//        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
//        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
//
//        // 获取表注释
//        String remarks = introspectedTable.getRemarks();
//
//        topLevelClass.addJavaDocLine("/**");
//        topLevelClass.addJavaDocLine(" * " + remarks);
//        topLevelClass.addJavaDocLine(" *");
//        topLevelClass.addJavaDocLine(" * @author " + author);
//        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
//        topLevelClass.addJavaDocLine(" */");
//    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        // 获取列注释
        String remarks = introspectedColumn.getRemarks();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + remarks);
        field.addJavaDocLine(" */");
    }
}
