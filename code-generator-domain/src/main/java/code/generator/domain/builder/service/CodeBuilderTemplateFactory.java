package code.generator.domain.builder.service;

import code.generator.domain.builder.model.entity.ColumnEntity;
import code.generator.domain.builder.model.entity.TableEntity;
import code.generator.domain.builder.repository.ICodeBuilderRepository;
import code.generator.types.utils.CommonUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.annotation.Resource;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hehongyi
 * @Date: 2024/7/28 11:05
 * @Description: 模板工厂
 */
public abstract class CodeBuilderTemplateFactory {

  @Resource
  private FreeMarkerConfigurer configurer;

  @Resource
  private ICodeBuilderRepository codeBuilderRepository;


  private String path = "/Users/hehongyi/Dev/Java/code-generator/code-generator-infrastructure/src/main/java/code/generator/infrastructure/persistent/po/";

  /**
   * 保存到文件
   */
  public void buildTemplate(Map<String, Object> model) throws IOException, TemplateException {
    Template template = configurer.getConfiguration().getTemplate(getTemplateFileName());
    Writer writer = new FileWriter(path);
    template.process(model, writer);


  }


  /**
   * 获取模板文件名
   *
   * @return 文件名称
   */
  protected abstract String getTemplateFileName();

  /**
   * 输出文件名
   *
   * @param model 模式
   * @return 文件名称
   */
  protected abstract String getOutputFileName(Map<String, Object> model);

  /**
   * 获取文件夹前缀名:例如java 的 src/main/java
   *
   * @return 文件夹前缀名
   */
  protected abstract String getProjectPrefix();

  /**
   * * 文件扩展名
   *
   * @return 扩展名
   */
  protected abstract String getExtension();


  /**
   * 别名
   *
   * @return 别名
   */
  protected abstract String alias();

  /**
   * 语言 java、sql、vue
   *
   * @return 语言
   */
  protected abstract String language();

  /**
   * zip要存储的目录
   *
   * @return zip要存储的目录
   */
  protected abstract String getZipParentPackage();

  /**
   * 获取输出包名
   *
   * @param model 模版
   * @return 输出包名
   */
  protected abstract String getOutputPackage(Map<String, Object> model);


}
