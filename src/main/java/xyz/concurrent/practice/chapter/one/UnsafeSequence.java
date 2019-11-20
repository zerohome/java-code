/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.concurrent.practice.chapter.one;

import xyz.concurrent.practice.annotation.NotThreadSafe;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年11月20日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@NotThreadSafe
public class UnsafeSequence {

	private static int sequence;

	public static int getSequence() {
		/*
		 * 	 读取-修改-写入的竞态条件
		 */
		return sequence++;
	}
}
