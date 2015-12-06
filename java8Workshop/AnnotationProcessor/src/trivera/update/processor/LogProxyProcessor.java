package trivera.update.processor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

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
@SupportedAnnotationTypes("trivera.update.processor.LogProxy")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LogProxyProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {

		for (TypeElement te : annotations) {
			for (Element e : roundEnv.getElementsAnnotatedWith(te)) {

				TypeElement classType = (TypeElement) e;

				generateClass(classType);
			}
		}

		return (true);
	}

	private void generateClass(TypeElement classElement) {

		try {
			LogProxy logProxy = classElement.getAnnotation(LogProxy.class);
			String loggableInterface = logProxy.value();

			PackageElement packageElement = (PackageElement) classElement
					.getEnclosingElement();

			String classFileName = classElement.getQualifiedName() + "Factory";

			JavaFileObject jfo = processingEnv.getFiler().createSourceFile(
					classFileName);

			BufferedWriter bw = new BufferedWriter(jfo.openWriter());
			bw.append("/* Generated on " + new Date() + " */");
			bw.newLine();
			bw.append("package ");
			bw.append(packageElement.getQualifiedName()).append(";");
			bw.newLine();
			bw.append("import trivera.update.processor.LoggingInvocatonHandler;");
			bw.newLine();
			bw.append("import java.lang.reflect.Proxy;");
			bw.newLine();
			bw.append("import ").append(classElement.getQualifiedName())
					.append(";");
			bw.newLine();
			bw.append("public class " + classElement.getSimpleName()
					+ "Factory {");
			bw.newLine();

			writeMethod(classElement, loggableInterface, bw);

			bw.append("}");
			bw.flush();
			bw.close();
			processingEnv.getMessager().printMessage(Kind.NOTE,
					"Created " + jfo.getName());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void writeMethod(TypeElement classElement,
			String loggableInterface, BufferedWriter bw) throws IOException {

		bw.append("   /*");
		bw.newLine();
		bw.append("Factory method");
		bw.newLine();
		bw.newLine();
		bw.append("   */");
		bw.newLine();
		bw.append("public static ").append(getSimpleName(loggableInterface))
				.append(" getInstance(){");
		bw.newLine();

		bw.append(classElement.getSimpleName()).append(" target = new ")
				.append(classElement.getSimpleName()).append("();");

		bw.newLine();
		bw.append("		return (").append(getSimpleName(loggableInterface))
				.append(") Proxy.newProxyInstance(")
				.append(classElement.getSimpleName().toString());
		bw.append(".class.getClassLoader(),new Class[] { ").append(
				getSimpleName(loggableInterface));
		bw.append(".class }, new LoggingInvocatonHandler(target));");
		bw.newLine();

		bw.append("}");

	}

	public String getSimpleName(String interfaceName) {

		int lastIndexOf = interfaceName.lastIndexOf(".");

		if (lastIndexOf >= 0 && lastIndexOf < interfaceName.length()) {

			return interfaceName.substring(lastIndexOf + 1);

		} else {
			return interfaceName;
		}
	}
}
