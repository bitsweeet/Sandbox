package freemarker.play;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FirstTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
	
	private Map<String,Object> getModel() {
		Map<String, Object> root = new HashMap<String, Object>();
		
		root.put("user", "Big Joe");
		
		Map<String, String> latest = new HashMap<String, String>();
		root.put("latestProduct", latest);
		
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");
		
		root.put("shipMethods", getShippingMethodsCol());
		root.put("selected", getSelectedShipMethods());
		
		return root;
	}
	
	private ShipMethod[] getShippingMethods() {
		return ShipMethod.values();
	}
	
	private Collection<ShipMethod> getShippingMethodsCol() {
		return new ArrayList<ShipMethod>(Arrays.asList(ShipMethod.values()));
	}
	
	private Map<String,Boolean> getSelectedShipMethods() {
		Map<String, Boolean> selected = new HashMap<String, Boolean>();
		
		selected.put(ShipMethod.Ground.getCode(), new Boolean(true));
		selected.put(ShipMethod.Overnight.getCode(), new Boolean(true));
		
		return selected;
	}
	
	private List<String> getSelectedShipMethodsValues() {
		List<String> selected = new ArrayList<String>();
		
		selected.add(ShipMethod.SecondDay.getCode());
		selected.add(ShipMethod.PriorityOvernight.getCode());
		
		return selected;
	}
}
