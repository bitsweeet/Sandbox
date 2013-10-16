package freemarker.play;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public abstract class BaseTest {

	/**
	 * @param args
	 */
	public void doIt() {
//		returns.shipping.label.ftl
		
		try {
			Configuration cfg = initialize();
			
			Template temp = cfg.getTemplate("test.ftl");
			
			Writer out = new OutputStreamWriter(System.out);
			temp.process(getModel(), out);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Configuration initialize() throws IOException {
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("./templates"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		return cfg;
	}
	
	protected abstract Map<String,Object> getModel();
}
