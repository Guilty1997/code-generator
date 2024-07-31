package code.generator.domain.builder.service.java;

import code.generator.domain.builder.service.CodeBuilderTemplateFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 10:49
 * @Description:
 */
@Component
public class JavaCodeBuilder extends CodeBuilderTemplateFactory {



  /**
   * 获取模板文件名
   *
   * @return 文件名称
   */
  @Override
  protected String getTemplateFileName() {
    return File.separator + "api" + File.separator + "controller.java.ftl";
  }

  /**
   * 输出文件名
   *
   * @param model 模式
   * @return 文件名称
   */
  @Override
  protected String getOutputFileName(Map<String, Object> model) {
    return model.get("controllerClassName").toString();
  }

  /**
   * 获取文件夹前缀名:例如java 的 src/main/java
   *
   * @return 文件夹前缀名
   */
  @Override
  protected String getProjectPrefix() {
    return ".java";
  }

  /**
   * * 文件扩展名
   *
   * @return 扩展名
   */
  @Override
  protected String getExtension() {
    return "controller";
  }

  /**
   * 别名
   *
   * @return 别名
   */
  @Override
  protected String alias() {
    return "java";
  }

  /**
   * 语言 java、sql、vue
   *
   * @return 语言
   */
  @Override
  protected String language() {
    return "";
  }

  /**
   * zip要存储的目录
   *
   * @return zip要存储的目录
   */
  @Override
  protected String getZipParentPackage() {
    return "java";
  }

  /**
   * 获取输出包名
   *
   * @param model 模版
   * @return 输出包名
   */
  @Override
  protected String getOutputPackage(Map<String, Object> model) {
    return model.get("controllerPkg").toString();
  }
}
