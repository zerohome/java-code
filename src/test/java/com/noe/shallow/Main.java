/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.noe.shallow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年9月23日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
public class Main {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap();
		map.put("int", "init");
		System.out.println(map.size());
		for (int i = 0; i < 12; i++) {
			map.put("i-" + i, "i-" + i);
		}
		System.out.println(map.size());
		map.put("resize", "resize");
	}
}
