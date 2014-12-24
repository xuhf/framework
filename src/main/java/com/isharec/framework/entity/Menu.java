package com.isharec.framework.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.ObjectUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
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
@Table(name = "f_menu")
@DynamicInsert
@DynamicUpdate
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Menu extends BaseEntity<Menu> {

	private static final long serialVersionUID = -3609813651172061032L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	@NotFound(action = NotFoundAction.IGNORE)
	@NotNull
	private Menu parent; // 父级菜单

	@Length(min = 1, max = 255)
	private String parentIds; // 所有父级编号

	@Length(min = 1, max = 100)
	private String name; // 名称

	@Length(min = 0, max = 255)
	private String href; // 链接

	@Length(min = 0, max = 20)
	private String target; // 目标（ mainFrame、_blank、_self、_parent、_top）

	@Length(min = 0, max = 100)
	private String icon; // 图标

	@NotNull
	private Integer sort; // 排序

	@Length(min = 1, max = 1)
	private String isShow; // 是否在菜单中显示（1：显示；0：不显示）

	@Length(min = 0, max = 200)
	private String permission; // 权限标识

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	@OrderBy(value = "sort")
	@Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Menu> childList = Lists.newArrayList();// 拥有子菜单列表

	@ManyToMany(mappedBy = "menuList", fetch = FetchType.LAZY)
	@OrderBy("id")
	@Fetch(FetchMode.SUBSELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	private List<Role> roleList = Lists.newArrayList(); // 拥有角色列表

	private int paddingNum;

	public Menu() {
		super();
		this.sort = 30;
	}

	public Menu(Long id) {
		this();
		this.id = id;
		this.parentIds = "";
	}

	@Transient
	public static void sortList(List<Menu> list, List<Menu> sourcelist) {
		for (Menu first : sourcelist) {
			// 一级菜单父节点为0
			if (first.getParent() == null || first.getParent().getId() == 0) {
				list.add(first);
				// 二级菜单
				for (Menu second : sourcelist) {
					// 判断是否还有子节点, 有则继续获取子节点
					if (second.getParent() != null
							&& second.getParent().getId() > 0
							&& second.getParent().getId() == first.getId()) {
						list.add(second);

						// 三级菜单
						for (Menu three : sourcelist) {
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

	@Transient
	public boolean isRoot() {
		return isRoot(this.id);
	}

	@Transient
	public static boolean isRoot(Long id) {
		return id == 1;
	}

	@Transient
	public String getActivitiGroupId() {
		return ObjectUtils.toString(getPermission());
	}

	@Transient
	public String getActivitiGroupName() {
		return ObjectUtils.toString(getId());
	}

	@Transient
	public int getPaddingNum() {
		this.paddingNum = this.parentIds.split(",").length - 1;
		return paddingNum;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
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

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<Menu> getChildList() {
		return childList;
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void setPaddingNum(int paddingNum) {
		this.paddingNum = paddingNum;
	}
}
