package trivera.update.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collection;
//import java.security.Policy.Parameters;
import java.util.logging.Logger;
import java.util.stream.Collector;

//import org.omg.Dynamic.Parameter;

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

	/**
	 * 
	 * @param method
	 *            The method that was invoked
	 * @param args
	 *            the values of the parameters
	 * @return A descriptive String
	 */
	public String createMethodString(Method method, Object[] args) {

		Parameter[] parameters = method.getParameters();
		StringBuilder paramNames = new StringBuilder(" Param Names ");
		StringBuilder paramVals = new StringBuilder(" Param Values ");
		
		for(Parameter p : parameters){
			paramNames.append(p.getName() + " ");
		}
		for(Object arg : args){
			paramVals.append(arg.toString() +  " " );
		}
		String methdString = method.getName() + paramNames.toString() + paramVals.toString();
		
		return methdString;
	}
}
