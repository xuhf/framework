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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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
	@NotFound(action = NotFoundAction.IGNORE)
	private Department parent;

	@Length(min = 1, max = 255)
	private String parentIds;

	@Column
	@Length(min = 1, max = 200)
	private String name;

	@Column
	@Length(min = 1, max = 200)
	private String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parent")
	private List<Department> subDepartments = Lists.newArrayList();

	public Department() {
		super();
	}

	public Department(Long id) {
		this();
		this.id = id;
		this.parentIds = "";
	}

	public Department getParent() {
		return parent;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}
	
	public String getParentIds() {
		return parentIds;
	}
	
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
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

	@Transient
	public static void sortList(List<Department> list,
			List<Department> sourcelist) {
		for (Department first : sourcelist) {
			// 一级菜单父节点为0
			if (first.getParent() == null || first.getParent().getId() == 0) {
				list.add(first);
				// 二级菜单
				for (Department second : sourcelist) {
					// 判断是否还有子节点, 有则继续获取子节点
					if (second.getParent() != null
							&& second.getParent().getId() > 0
							&& second.getParent().getId() == first.getId()) {
						list.add(second);
						// 三级菜单
						for (Department three : sourcelist) {
							if (three.getParent() != null
									&& three.getParent().getId() > 0
									&& three.getParent().getId() == second
											.getId()) {
								list.add(three);
							}
						}
					}
				}
			}
		}
	}
}
