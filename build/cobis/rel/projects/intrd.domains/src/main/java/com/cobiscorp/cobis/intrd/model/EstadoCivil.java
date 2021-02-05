package com.cobiscorp.cobis.intrd.model;

import java.util.ArrayList;
import java.util.List;
import com.cobiscorp.designer.api.Property;

public class EstadoCivil {

	public static final String EN_ESTADOCVL_592 = "EN_ESTADOCVL_592";
	
	public static final String VERSION = "1.0.0";
	
	public static final String ENTITY_NAME = "EstadoCivil";
	
	
	public static final Property<String> ESTADOCIVIL = new Property<String>("estadoCivil", String.class, false);
	
	public static final List<Property<?>> getPks() {
		List<Property<?>> pks = new ArrayList<Property<?>>();
		return pks;
	}

}
