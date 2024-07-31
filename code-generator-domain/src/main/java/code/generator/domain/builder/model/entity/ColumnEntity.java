package code.generator.domain.builder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Types;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 16:48
 * @Description: 数据库表字段信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColumnEntity {
  /**
   * 列名
   */
  private String columnName;

  /**
   * 列类型
   */
  private String columnType;

  /**
   * 列注释
   */
  private String columnComment;


  // 映射SQL类型到Java类型



}
