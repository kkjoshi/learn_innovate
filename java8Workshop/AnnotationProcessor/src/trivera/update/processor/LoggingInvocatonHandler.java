package trivera.update.processor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.logging.Logger;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of the Trivera
 * Group, Inc.
 *
 * Copyright c 2015 Trivera Technologies, LLC. http://www.triveratech.com
 * 
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */
public class LoggingInvocatonHandler implements InvocationHandler {
	private static final Logger LOGGER = Logger.getGlobal();
	private Object target;

	public LoggingInvocatonHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		LOGGER.info(createMethodString(method, args));

		return method.invoke(target, args);
	}

	public String createMethodString(Method method, Object[] args) {
		String methodName = method.getName();
		String returnType = method.getReturnType().getSimpleName();

		StringBuilder sb = new StringBuilder();
		sb.append("Invoking method '").append(returnType).append(" ")
				.append(methodName).append("'");
		sb.append("\n  with Parameters: \n");

		Parameter[] parameters = method.getParameters();
		for (int i = 0; i < parameters.length; i++) {

			String paramName = parameters[i].getName();
			String paramType = parameters[i].getType().getSimpleName();

			String value = args[i] != null ? args[i].toString() : "null";

			sb.append("      ").append(paramName).append("(").append(paramType)
					.append(")=").append(value).append("\n");
		}
		return sb.toString();
	}
}
