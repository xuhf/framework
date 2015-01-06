package com.isharec.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.isharec.framework.base.persistence.BaseEntity;

@Entity
@Table(name = "f_system_parameter")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SystemParameter extends BaseEntity<SystemParameter> {

	private static final long serialVersionUID = 9109401370738767909L;

	@Length(min = 1, max = 100)
	private String name; // 参数名称

	@Length(min = 1, max = 200)
	private String value; // 参数值

	@Length(min = 1, max = 100)
	private String code; // 参数代码

	@Column
	private String remarks; // 备注

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
