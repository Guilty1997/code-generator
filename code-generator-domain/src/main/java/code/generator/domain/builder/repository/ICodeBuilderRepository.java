package code.generator.domain.builder.repository;

import code.generator.domain.builder.model.entity.ColumnEntity;
import code.generator.domain.builder.model.entity.TableEntity;

import java.util.List;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 15:03
 * @Description:
 */
public interface ICodeBuilderRepository {

  /**
   * 获取表信息
   *
   * @return 表信息
   */
  List<String> getCatalogs();


  /**
   * 获取表名称
   *
   * @param catalog 架构名称
   * @return 表名称
   */
  List<TableEntity> getTableNames(String catalog);

  //获取表字段信息

  /**
   * 获取表字段信息
   *
   * @param tableName 表名称
   * @return 表字段信息
   */
  List<ColumnEntity> getTableColumns(String tableName);

}
