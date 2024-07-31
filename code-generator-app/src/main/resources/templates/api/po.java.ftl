package ${packageName};


import lombok.Data;

<#list importPackages as importPackage>
<#if importPackage.importPackage != ''>
import ${importPackage.importPackage};
 </#if>
</#list>


/**
* @Author: ${author}
* @Date: ${createTime}
* @Description: ${tableComment}
*/
@Data
public class ${tableName} {

<#list columnInfos as field>
    /**
    * ${field.columnComment}
    */
    private ${field.columnType} ${field.columnName};

</#list>
}