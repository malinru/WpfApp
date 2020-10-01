package com.rits.snowflake.generator.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "gen_datasource")
@ApiModel
@SQLDelete(sql = "update gen_datasource set status = 0 where id = ?")
@Where(clause = "status != 0")
public class GeneratorDatasource extends AbstarctEntity {
	
	@ApiModelProperty(value = "数据源名称")
    private String datasourceName;
	
	@ApiModelProperty(value = "数据源")
    private String datasource;

    @ApiModelProperty(value = "用户名")
    private String login;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "jdbc url")
    private String jdbcUrl;

    @ApiModelProperty(value = "jdbc驱动类")
    private String jdbcDriverClass;

    @ApiModelProperty(value = "备注", hidden = true)
    private String comments;

    @ApiModelProperty(value = "数据库名", hidden = true)
    private String databaseName;
    
}
