package tsc.web.framework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import tsc.web.utils.DBUtils;

@Retention(RetentionPolicy.RUNTIME)
public @interface Control {

	String value();
}
