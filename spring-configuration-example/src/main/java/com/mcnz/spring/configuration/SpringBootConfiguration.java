package com.mcnz.spring.configuration;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="spring.boot.config.example")
@Component
public class SpringBootConfiguration {
	
	private final InnerClass innerClass = new InnerClass();
	
	public InnerClass getInnerClass() {
		return innerClass;
	}
	
	@ConfigurationProperties(prefix="innerClass")
	public class InnerClass {
		private String property1;
		private String property2;
		private String property3;
		public String getProperty1() {return property1;}
		public void setProperty1(String p) { property1 = p; }
		public String getProperty2() {return property2;}
		public void setProperty2(String p) { property2 = p; }
		public String getProperty3() {return property3;}
		public void setProperty3(String p) { property3 = p; }
	}
	
	
	  
	  
	  private String company; private int suite; private boolean active; private
	  Map<String, String> map; private List<String> list;
	  
	  public Map<String, String> getMap() {return map;} public void
	  setMap(Map<String, String> m) {map = m;} public List<String> getList()
	  {return list;} public void setList(List<String> l) {list = l;}
	  
	  public String getCompany() { return company; } public void setCompany(String
	  c) { company = c; } public int getSuite() { return suite; } public void
	  setSuite(int s) { suite = s; } public boolean isActive() { return active; }
	  public void setActive(boolean a) { active = a; }
	 


}



