package com.ayt.example.task;

import lombok.Getter;

/**
 * Created by ayt on ${DTAE}
 * just try
 */
public enum TeamEnum {
	SPIDER(0,"商家组","SPIDER"),
	FLASH(1,"骑手组","FLASH"),
	HAWKEYE(2,"支撑组","HAWKEYE"),
	BIGBANGTEST(3,"测开组","BIGBANGTEST");

	@Getter
	int code;
	@Getter
	String desc;
	@Getter
	String ename;

	TeamEnum(int code, String desc, String ename) {
		this.code = code;
		this.desc = desc;
		this.ename = ename;
	}


	public static TeamEnum toEnum(int code) {
		TeamEnum[] var = values();
		for(int i=0; i<var.length; i++) {
			TeamEnum en = var[i];
			if(en.code == code) {
				return en;
			}
		}
		return null;
	}
}
