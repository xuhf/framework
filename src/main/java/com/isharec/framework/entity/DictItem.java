package com.isharec.framework.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import com.isharec.framework.base.persistence.BaseEntity;

@Entity
@Table(name = "f_dict_header")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DictItem extends BaseEntity<DictItem> {

	private static final long serialVersionUID = -6196834089146076366L;

	@Column
	@Length(min = 1, max = 100)
	private String name;

	@Column
	@Length(min = 1, max = 100)
	private String value;

	@ManyToOne()
	@Fetch(FetchMode.SUBSELECT)
	@Cascade(value = { CascadeType.ALL })
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private DictHeader dictHeader;

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

	public DictHeader getDictHeader() {
		return dictHeader;
	}

	public void setDictHeader(DictHeader dictHeader) {
		this.dictHeader = dictHeader;
	}
}
