package com.cobiscorp.cobis.intrd.model;

import java.util.ArrayList;
import java.util.List;
import com.cobiscorp.designer.api.Property;

public class CuentaCorriente {

	public static final String EN_CUENTACRE_871 = "EN_CUENTACRE_871";
	
	public static final String VERSION = "1.0.0";
	
	public static final String ENTITY_NAME = "CuentaCorriente";
	
	
	public static final Property<String> NUMEROCUENTA = new Property<String>("numeroCuenta", String.class, false);
	
	public static final Property<String> CEDULACLIENTE = new Property<String>("cedulaCliente", String.class, false);
	
	public static final Property<Double> SALDOCUENTA = new Property<Double>("saldoCuenta", Double.class, false);
	
	public static final List<Property<?>> getPks() {
		List<Property<?>> pks = new ArrayList<Property<?>>();
		return pks;
	}

}
