package com.rits.snowflake.generator.domain;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@MappedSuperclass
@ApiModel
public abstract class AbstarctEntity implements Auditable<String,Long,LocalDateTime> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value = "自增主键")
	private Long id = 0L;

	@CreatedBy
	@ApiModelProperty(value = "创建者")
	private String createdBy;

	@CreatedDate
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createdDate;
	
	@LastModifiedBy
	@ApiModelProperty(value = "最后修改者")
	private String lastModifiedBy;

	@LastModifiedDate
	@ApiModelProperty(value = "最后修改时间")
	private LocalDateTime lastModifiedDate;
	
	@ApiModelProperty(value = "状态：0删除 1启用 2禁用")
    private Integer status;
	
	@Override
	public Long getId() {		
		return this.id;
	}

	@Override
	public Optional<String> getCreatedBy() {
		return Optional.of(this.createdBy);
	}

	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public Optional<LocalDateTime> getCreatedDate() {		
		return Optional.of(this.createdDate);
	}

	@Override
	public void setCreatedDate(LocalDateTime creationDate) {
		this.createdDate = creationDate;
	}

	@Override
	public Optional<String> getLastModifiedBy() {		
		return Optional.of(this.lastModifiedBy);
	}

	@Override
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public Optional<LocalDateTime> getLastModifiedDate() {		
		return Optional.of(this.lastModifiedDate);
	}

	@Override
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public boolean isNew() {
		return this.id == 0;
	}	
}
