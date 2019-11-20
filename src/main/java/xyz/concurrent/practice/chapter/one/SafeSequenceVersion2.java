/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.concurrent.practice.chapter.one;

import java.util.concurrent.atomic.AtomicInteger;

import xyz.concurrent.practice.annotation.ThreadSafe;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年11月20日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@ThreadSafe
public class SafeSequenceVersion2 {

	/*
	 * 	 线程安全类
	 */
	private static final AtomicInteger sequence = new AtomicInteger(0);

	public static int getSequence() {
		return sequence.incrementAndGet();
	}
}
