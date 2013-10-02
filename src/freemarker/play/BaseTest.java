package freemarker.play;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public abstract class BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		returns.shipping.label.ftl
		
		try {
			FirstTest test = new FirstTest();
			Configuration cfg = test.initialize();
			
			Template temp = cfg.getTemplate("test.ftl");
			
			Writer out = new OutputStreamWriter(System.out);
			temp.process(test.getModel(), out);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	private Configuration initialize() throws IOException {
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("./templates"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		return cfg;
	}
	
	abstract protected BaseTest createMe();
}
