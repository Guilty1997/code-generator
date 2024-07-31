package ${poPkg};


import lombok.Data;

/**
* @Author: ${author}
* @Date: ${date}
* @Description: ${comment}
*/
@Data
public class ${poClassName} {

<#list columns as field>
    /**
    * ${field.fieldComment}
    */
    private ${field.javaType} ${field.javaField};

</#list>
}