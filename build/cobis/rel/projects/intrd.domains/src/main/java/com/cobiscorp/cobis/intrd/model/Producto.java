package com.cobiscorp.cobis.intrd.model;

import java.util.ArrayList;
import java.util.List;
import com.cobiscorp.designer.api.Property;

public class Producto {

	public static final String EN_PRODUCTOO_903 = "EN_PRODUCTOO_903";
	
	public static final String VERSION = "1.0.0";
	
	public static final String ENTITY_NAME = "Producto";
	
	
	public static final Property<Character> TIPO = new Property<Character>("tipo", Character.class, false);
	
	public static final Property<Double> COSTO = new Property<Double>("costo", Double.class, false);
	
	public static final Property<Integer> MODO = new Property<Integer>("modo", Integer.class, false);
	
	public static final Property<Integer> IDPRODUCTO = new Property<Integer>("idProducto", Integer.class, false);
	
	public static final Property<String> DESCRIPCION = new Property<String>("descripcion", String.class, false);
	
	public static final Property<String> TIPOH = new Property<String>("tipoh", String.class, false);
	
	public static final Property<Character> ABREVIATURA = new Property<Character>("abreviatura", Character.class, false);
	
	public static final Property<Character> ESTADO = new Property<Character>("estado", Character.class, false);
	
	public static final Property<Double> SALDOMINIMO = new Property<Double>("saldoMinimo", Double.class, false);
	
	public static final Property<Integer> FORMATOFECHA = new Property<Integer>("formatoFecha", Integer.class, false);
	
	public static final List<Property<?>> getPks() {
		List<Property<?>> pks = new ArrayList<Property<?>>();
		return pks;
	}

}
