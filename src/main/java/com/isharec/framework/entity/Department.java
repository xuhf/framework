package com.isharec.framework.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import com.isharec.framework.base.persistence.BaseEntity;

@Entity
@Table(name = "f_department")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department extends BaseEntity<Department> {

	private static final long serialVersionUID = 195700386321829120L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Department parent;

	@Column
	@Length(min = 1, max = 200)
	private String name;

	@Column
	@Length(min = 1, max = 200)
	private String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Department> subDepartments = Lists.newArrayList();

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Department> getSubDepartments() {
		return subDepartments;
	}

	public void setSubDepartments(List<Department> subDepartments) {
		this.subDepartments = subDepartments;
	}
}
