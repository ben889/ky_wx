package com.framework.consts;
/**
 * 权限、枚举
 *
 */
public enum PermissionEnum {
	VIEW("VIEW", "查看"), 
	UPDATE("UPDATE", "修改"), 
	DELETE("DELETE", "删除"),
	INSERT("INSERT", "添加");

	private String code;
	private String name;

	private PermissionEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getName(String code) {
		for (PermissionEnum c : PermissionEnum.values()) {
			if (c.getCode().equals(code)) {
				return c.getName();
			}
		}
		return "";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
