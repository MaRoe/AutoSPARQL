package org.aksw.autosparql.tbsl.gui.vaadin.model;

import java.util.Map;

public class InfoTemplate {

	private String htmlString;

	private Map<String, String> propertyMap;

	public InfoTemplate(String htmlString, Map<String, String> propertyMap) {
		this.htmlString = htmlString;
		this.propertyMap=propertyMap;
	}

	public String getHtmlString() {
		return htmlString;
	}

	public Map<String, String> getPropertyMap() {
		return propertyMap;
	}

	public String fill(BasicResultItem item){
		String filledTemplate = htmlString.replace("label", item.getLabel());
		filledTemplate = filledTemplate.replace("imageURL", item.getImageURL());
		filledTemplate = filledTemplate.replace("description", item.getDescription());
		return filledTemplate;
	}

}
