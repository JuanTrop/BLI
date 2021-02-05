package com.cobiscorp.cobis.intrd.model;

import java.util.ArrayList;
import java.util.List;
import com.cobiscorp.designer.api.Property;

public class Ciudadano {

	public static final String EN_CIUDADANO_962 = "EN_CIUDADANO_962";
	
	public static final String VERSION = "1.0.0";
	
	public static final String ENTITY_NAME = "Ciudadano";
	
	
	public static final Property<String> ACTIVIDADACTUAL = new Property<String>("actividadActual", String.class, false);
	
	public static final Property<String> ESTADOCIVIL = new Property<String>("estadoCivil", String.class, false);
	
	public static final List<Property<?>> getPks() {
		List<Property<?>> pks = new ArrayList<Property<?>>();
		return pks;
	}

}
