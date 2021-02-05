package com.cobiscorp.cobis.intrd.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cobiscorp.designer.api.Property;

public class CuentaAhorro {

	public static final String EN_CUENTAAOR_710 = "EN_CUENTAAOR_710";
	
	public static final String VERSION = "1.0.0";
	
	public static final String ENTITY_NAME = "CuentaAhorro";
	
	
	public static final Property<Date> FECHACREACION = new Property<Date>("fechaCreacion", Date.class, false);
	
	public static final Property<Date> FECHAMODIFICACION = new Property<Date>("fechaModificacion", Date.class, false);
	
	public static final Property<Integer> CACLIENTE = new Property<Integer>("caCliente", Integer.class, false);
	
	public static final Property<Double> CASALDO = new Property<Double>("caSaldo", Double.class, false);
	
	public static final Property<String> CABANCO = new Property<String>("caBanco", String.class, false);
	
	public static final List<Property<?>> getPks() {
		List<Property<?>> pks = new ArrayList<Property<?>>();
		return pks;
	}

}
