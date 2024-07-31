package code.generator.test.domain;

import code.generator.domain.builder.model.aggregate.CodeModelBuilder;
import code.generator.domain.builder.model.aggregate.GeneratorDetail;
import code.generator.domain.builder.model.entity.ColumnEntity;
import code.generator.domain.builder.model.entity.TableEntity;
import code.generator.domain.builder.service.java.JavaCodeBuilder;
import code.generator.domain.builder.service.java.PoCodeBuilder;
import code.generator.domain.builder.service.java.TestCodeBuilder;
import code.generator.domain.builder.repository.ICodeBuilderRepository;
import freemarker.template.TemplateException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @Author: hehongyi
 * @Date: 2024/7/30 10:55
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaCodeTest {

  @Resource
  private JavaCodeBuilder codeBuilder;

  @Resource
  private PoCodeBuilder poCodeBuilder;

  @Resource
  private TestCodeBuilder testCodeBuilder;

  @Resource
  private ICodeBuilderRepository codeBuilderRepository;

  @Test
  public void test_javaCode() throws IOException, TemplateException {
    CodeModelBuilder codeModelBuilder = new CodeModelBuilder();
    List<ColumnEntity> columns = codeBuilderRepository.getTableColumns("rule_tree");

    GeneratorDetail detail = GeneratorDetail.builder()
            .baseInfoInfo(GeneratorDetail.BaseInfoInfo.builder()
                    .packageName("code.generator")
                    .author("hehongyi")
                    .createTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
                    .build())
            .tableInfo(GeneratorDetail.TableInfo.builder()
                    .tableName("rule_tree")
                    .tableComment("规则树")
                    .build())
            .columnInfos(columns.stream().map(column -> GeneratorDetail.ColumnInfo.builder()
                    .columnName(column.getColumnName())
                    .columnComment(column.getColumnComment())
                    .columnType(column.getColumnType())
                    .build()).toList())
            .build();
    Map<String, Object> model = codeModelBuilder.builderBaseInfo(detail).builderEntity(detail).getModel();
    poCodeBuilder.buildTemplate(model);
  }

  @Test
  public void test_codeBuilderRepository() {
    List<String> catalogs = codeBuilderRepository.getCatalogs();
    for (String catalog : catalogs) {
      log.info("catalog:{}", catalog);
    }
    List<TableEntity> bigMarket = codeBuilderRepository.getTableNames("big_market");
    for (TableEntity table : bigMarket) {

      log.info("table:{}", table);
    }
    List<ColumnEntity> ruleTree = codeBuilderRepository.getTableColumns("rule_tree");
    for (ColumnEntity column : ruleTree) {

      log.info("column:{}", column);
    }
  }

}
