/*
 * Copyright(c) by 2017-2019 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.concurrent.practice.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年11月20日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThreadSafe {

}
