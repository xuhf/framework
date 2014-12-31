package com.isharec.framework.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

import com.google.common.collect.Lists;
import com.isharec.framework.base.persistence.BaseEntity;

@Entity
@Table(name = "f_dict_header")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class DictHeader extends BaseEntity<DictHeader> {

	private static final long serialVersionUID = -3941325037390495664L;

	@Column
	@Length(min = 1, max = 100)
	private String name;

	@Column
	@Length(min = 1, max = 100)
	private String value;

	@OneToMany(mappedBy = "dictHeader")
	@OrderBy("id")
	@Cascade(value = { CascadeType.ALL })
	@Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<DictItem> items = Lists.newArrayList();

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

	public List<DictItem> getItems() {
		return items;
	}

	public void setItems(List<DictItem> items) {
		this.items = items;
	}
}
