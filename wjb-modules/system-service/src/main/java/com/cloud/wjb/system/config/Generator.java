package com.cloud.wjb.system.config;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Slark
 * @version 1.0
 * @date 2020/10/27 上午11:27
 */
public class Generator {

    /**
     * 在这里修改各个文件存放对的路径
     **/
    private static final String packagePath = "com.cloud.wjb.system";

    /**
     * 是否生成entity
     **/
    private static final Boolean generateEntity = true;
    private static final String entityPackagePath = "entity";

    private static final Boolean generateService = true;
    private static final String servicePackagePath = "service";

    private static final Boolean generateImpl = true;
    private static final String serviceImplPackagePath = "service.impl";

    private static final Boolean generateMapper = true;
    private static final String mapperPackagePath = "mapper";

    private static final Boolean generateXml = false;
    private static final String xmlPackagePath = "mapper";

    private static final Boolean generateController = true;
    private static final String controllerPackagePath = "controller";

    /**
     * 如果表没有前缀，记得 改为false
     **/
    private static final boolean ifDeleteTablePreFix = true;
    /**
     * 表前缀
     */
    private static final String tablePreFix = "hw";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/wjb-modules/system-service";
        gc.setOutputDir(projectPath + "/src/main/java");
        /** 是否覆盖已有文件 默认值：false **/
        gc.setFileOverride(true);
        /** 是否在xml中添加二级缓存配置 **/
        gc.setEnableCache(false);
        /** 是否在xml中添加BaseResultMap **/
        gc.setBaseResultMap(true);
        /** 是否在xml中添加BaseColumnList **/
        gc.setBaseColumnList(true);

        /** Mapper 命名方式 **/
        gc.setMapperName("%sMapper");
        /** Mapper.xml 命名方式 **/
        gc.setXmlName("%sMapper");
        /** 实体命名方式 **/
        gc.setEntityName("%sEntity");
        /** Service 命名方式 **/
        gc.setServiceName("%sService");
        /** ServiceImpl 命名方式 **/
        gc.setServiceImplName("%sServiceImpl");
        /** ServiceImpl 命名方式 **/
        gc.setControllerName("%sController");
        /** 指定生成的主键的ID类型 **/
//        gc.setIdType(IdType.AUTO);
        gc.setAuthor("fuqiang");
        /** 是否打开输出目录**/
        gc.setOpen(false);
        /** swagger **/
        gc.setSwagger2(true);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);


        /** 生成包相关配置 **/
        PackageConfig packageConfig = new PackageConfig();
        /** 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名**/
        packageConfig.setParent(packagePath);
        /** 父包模块名 ***/
//        packageConfig.setModuleName(scanner("模块名"));
        /** 各个模块包名 **/
        packageConfig.setEntity(entityPackagePath);
        packageConfig.setService(servicePackagePath);
        packageConfig.setServiceImpl(serviceImplPackagePath);
        packageConfig.setMapper(mapperPackagePath);
        packageConfig.setXml(xmlPackagePath);
        packageConfig.setController(controllerPackagePath);
        mpg.setPackageInfo(packageConfig);

        /** 数据源配置 **/
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://42.194.173.207:31234/cloud?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=CTT&characterEncoding=UTF8&useSSL=false&allowMultiQueries=true&nullCatalogMeansCurrent=true");
        // dsc.setSchemaName("public");
        dsc.setDriverName("org.mariadb.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("wjb2022");
        mpg.setDataSource(dsc);


        /** 数据库表配置 **/
        StrategyConfig strategy = new StrategyConfig();
        /** 是否大写命名 **/
        strategy.setCapitalMode(false);
        /** 是否跳过视图 **/
        strategy.setSkipView(false);
        /** 数据库表映射到实体的命名策略 NamingStrategy **/
        strategy.setNaming(NamingStrategy.underline_to_camel);
        /** 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行 **/
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        /** 表前缀 生成实体类的时候如果设置了前缀命名会去掉前缀 **/
        if (ifDeleteTablePreFix) {
            strategy.setTablePrefix(tablePreFix + "_");
        }
        /** 字段前缀 生成实体类的时候如果设置了前缀命名会去掉前缀 **/
//        strategy.setFieldPrefix();
        /** 自定义基础的Entity类，公共字段 **/
//        strategy.setSuperEntityColumns()
        /** 自定义继承的类全称，带包名 **/
//        strategy.setSuperEntityClass();
//        strategy.setSuperMapperClass();
//        strategy.setSuperServiceClass();
//        strategy.setSuperServiceImplClass();
//        strategy.setSuperControllerClass();
        /**
         * 默认激活进行sql模糊表名匹配
         * 关闭之后likeTable与notLikeTable将失效，include和exclude将使用内存过滤
         * 如果有sql语法兼容性问题的话，请手动设置为false
         */
//        strategy.setEnableSqlFilter(true);
        /** 需要包含的表名，当enableSqlFilter为false时，允许正则表达式（与exclude二选一配置） **/
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        strategy.setExclude();
        /** 自3.3.0起，模糊匹配表名（与notLikeTable二选一**/
//        strategy.setLikeTable()
//        strategy.setNotLikeTable()
        /** 【实体】是否生成字段常量（默认 false） **/
        strategy.setEntityColumnConstant(false);

        /** 【实体】是否为lombok模型（默认 false）3.3.2以下版本默认生成了链式模型，3.3.2以后，默认不生成，如有需要，请开启 chainModel **/
        strategy.setEntityLombokModel(true);
        /** 【实体】是否为链式模型（默认 false）**/
//        strategy.setChainModel(true);

        /** Boolean类型字段是否移除is前缀（默认 false） **/
//        strategy.setEntityBooleanColumnRemoveIsPrefix();

        /** 生成 @RestController 控制器 **/
        strategy.setRestControllerStyle(true);

        /** 驼峰转连字符 **/
        strategy.setControllerMappingHyphenStyle(true);

        /** 是否生成实体时，生成字段注解 **/
        strategy.setEntityTableFieldAnnotationEnable(true);

        /** 逻辑删除属性名称 **/
        strategy.setLogicDeleteFieldName("is_delete");

        mpg.setStrategy(strategy);


        /**
         * 自定义文件模板
         * 指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
         * 注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
         */
        TemplateConfig templateConfig = new TemplateConfig();

        if (!generateEntity) {
            templateConfig.setEntity("");
        }

        if (!generateController) {
            templateConfig.setController("");
        }

        if (!generateService) {
            templateConfig.setService("");
        }

        if (!generateImpl) {
            templateConfig.setServiceImpl("");
        }

        if (!generateXml) {
            templateConfig.setXml("");
        }

        if (!generateMapper) {
            templateConfig.setMapper("");
        }

//        templateConfig.setXml();
//        templateConfig.setEntity();
//        templateConfig.setController("templates/generator/controller.java");
//        templateConfig.setMapper();
//        templateConfig.setService();
//        templateConfig.setServiceImpl();
        /** Kotin 实体类模板 **/
//        templateConfig.setEntityKt();
        mpg.setTemplate(templateConfig);


        /**
         * 注入配置，通过该配置，可注入模板自定义参数等操作以实现个性化操作
         *
         * entity2.java.ftl
         * 自定义属性注入abc=${cfg.abc}
         *
         * entity2.java.vm
         * 自定义属性注入abc=$!{cfg.abc}
         */
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                /** 注入自定义 Map 对象(注意需要setMap放进去) **/
                Map<String, Object> map = new HashMap<>();
                map.put("serviceInstance", captureName(gc.getServiceName()));
                this.setMap(map);
            }
        };
        mpg.setCfg(injectionConfig);


        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }


    private static String captureName(String name) {
        char[] cs = name.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);
    }
}
