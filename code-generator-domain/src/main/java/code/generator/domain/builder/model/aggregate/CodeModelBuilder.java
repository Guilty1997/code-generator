package code.generator.domain.builder.model.aggregate;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hehongyi
 * @Date: 2024/7/31 09:07
 * @Description: 编码模型构建器
 */
@Getter
public class CodeModelBuilder {

  private final Map<String, Object> model = new HashMap<>();

  public CodeModelBuilder builderBaseInfo(GeneratorDetail generatorDetail) {
    GeneratorDetail.BaseInfoInfo baseInfoInfo = generatorDetail.getBaseInfoInfo();
    model.put("packageName", baseInfoInfo.getPackageName());
    model.put("createTime", baseInfoInfo.getCreateTime());
    model.put("author", baseInfoInfo.getAuthor());
    return this;
  }

  public CodeModelBuilder builderEntity(GeneratorDetail generatorDetail) {
    GeneratorDetail.TableInfo tableInfo = generatorDetail.getTableInfo();
    model.put("tableName", tableInfo.getTableName());
    model.put("tableComment", tableInfo.getTableComment());
    List<GeneratorDetail.ColumnInfo> columnInfos = generatorDetail.getColumnInfos();
    List<String> importPackages = new ArrayList<>();
    List<Map<String, String>> columnList = new ArrayList<>();
    for (GeneratorDetail.ColumnInfo columnInfo : columnInfos) {
      Map<String, String> map = new HashMap<>();
      map.put("columnName", columnInfo.getColumnName());
      map.put("columnComment", columnInfo.getColumnComment());
      map.put("columnType", columnInfo.getColumnType());
      importPackages.add(columnInfo.getImportPackage());
      columnList.add(map);
    }
    model.put("columnInfos", columnList);
    model.put("importPackages", importPackages);
    return this;
  }

}
