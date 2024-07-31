package code.generator.domain.builder.model.aggregate;

import code.generator.types.utils.CommonUtils;
import lombok.Getter;

import java.util.*;

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
    model.put("tableName", CommonUtils.underlineToCamel(tableInfo.getTableName(), true));
    model.put("tableComment", tableInfo.getTableComment());
    List<GeneratorDetail.ColumnInfo> columnInfos = generatorDetail.getColumnInfos();
    Set<Map<String, String>> importPackages = new HashSet<>();
    List<Map<String, String>> columnList = new ArrayList<>();
    for (GeneratorDetail.ColumnInfo columnInfo : columnInfos) {
      Map<String, String> columnMap = new HashMap<>();
      columnMap.put("columnName", CommonUtils.underlineToCamel(columnInfo.getColumnName(), false));
      columnMap.put("columnComment", columnInfo.getColumnComment());
      columnMap.put("columnType", columnInfo.mapSqlTypeToJavaType());
      Map<String, String> importPacckageMap = new HashMap<>();
      importPacckageMap.put("importPackage", columnInfo.mapSqlTypeToImportPackage());
      columnList.add(columnMap);
      importPackages.add(importPacckageMap);

    }
    model.put("columnInfos", columnList);
    model.put("importPackages", importPackages);
    return this;
  }

}
