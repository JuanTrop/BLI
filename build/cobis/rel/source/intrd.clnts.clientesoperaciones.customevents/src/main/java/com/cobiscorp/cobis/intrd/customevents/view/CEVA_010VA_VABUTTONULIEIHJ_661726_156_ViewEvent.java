/*
 * Archivo: VW_CLIENTESIO_726_ViewEvent.java
 * Fecha: 4/02/2021 10:15:25 PM
 *
 * Esta aplicacion es parte de los paquetes bancarios propiedad de COBISCORP.
 * Su uso no autorizado queda expresamente prohibido asi como cualquier
 * alteracion o agregado hecho por alguno de sus usuarios sin el debido
 * consentimiento por escrito de COBISCORP.
 * Este programa esta protegido por la ley de derechos de autor y por las
 * convenciones internacionales de propiedad intelectual. Su uso no
 * autorizado dara derecho a COBISCORP para obtener ordenes de secuestro
 * o retencion y para perseguir penalmente a los autores de cualquier infraccion.
 */

package com.cobiscorp.cobis.intrd.customevents.view;

import java.util.List;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.Service;

import com.cobiscorp.cobis.commons.domains.log.ILogger;
import com.cobiscorp.cobis.commons.log.LogFactory;
import com.cobiscorp.designer.api.DataEntity;
import com.cobiscorp.designer.api.DynamicRequest;
import com.cobiscorp.designer.api.builder.ViewEventBuilder;
import com.cobiscorp.designer.api.customization.*;
import com.cobiscorp.designer.api.customization.arguments.*;
import com.cobiscorp.designer.api.managers.DesignerManagerException;

/**
 * Personalizacion de Eventos del Formulario
 *
 * VW_CLIENTESIO_726_ViewEvent - View of ClientesOperaciones
 *
 */
@Component
@Service({ViewEventBuilder.class})
@Properties(value={
		@Property(name = "view.id", value = "VW_CLIENTESIO_726"),
		@Property(name = "view.version", value = "1.0.0")
})
public class CEVA_010VA_VABUTTONULIEIHJ_661726_156_ViewEvent extends ViewEventBuilder
 implements IExecuteCommand
{
	/**
	 * Instancia de Logger
	 */
	private static final ILogger logger = LogFactory.getLogger(CEVA_010VA_VABUTTONULIEIHJ_661726_156_ViewEvent.class);
    
	@Reference(name="iExecuteCommandVA_VABUTTONULIEIHJ_661726",referenceInterface =IExecuteCommand.class,bind = "setiExecuteCommandVA_VABUTTONULIEIHJ_661726",unbind = "unsetiExecuteCommandVA_VABUTTONULIEIHJ_661726",cardinality = ReferenceCardinality.MANDATORY_UNARY,policy=ReferencePolicy.DYNAMIC,target="(&(view.id=VW_CLIENTESIO_726)(view.version=1.0.0)(view.controlId=VA_VABUTTONULIEIHJ_661726))")
	private IExecuteCommand iExecuteCommandVA_VABUTTONULIEIHJ_661726;

	public void setiExecuteCommandVA_VABUTTONULIEIHJ_661726(IExecuteCommand iExecuteCommandVA_VABUTTONULIEIHJ_661726) {
		this.iExecuteCommandVA_VABUTTONULIEIHJ_661726 = iExecuteCommandVA_VABUTTONULIEIHJ_661726;
	}

	public void unsetiExecuteCommandVA_VABUTTONULIEIHJ_661726(IExecuteCommand iExecuteCommandVA_VABUTTONULIEIHJ_661726) {
		this.iExecuteCommandVA_VABUTTONULIEIHJ_661726 = iExecuteCommandVA_VABUTTONULIEIHJ_661726;
	}

	@Reference(bind = "setBLI6088_bli_crearcuentacorriente", unbind = "unsetBLI6088_bli_crearcuentacorriente", cardinality = ReferenceCardinality.MANDATORY_UNARY,target="(bli.id=BLI6088_bli_crearcuentacorriente)")
	private com.cobiscorp.designer.bli.api.IBLIExecutor bLI6088_bli_crearcuentacorriente;
	public void setBLI6088_bli_crearcuentacorriente(com.cobiscorp.designer.bli.api.IBLIExecutor bLI6088_bli_crearcuentacorriente) {
		this.bLI6088_bli_crearcuentacorriente = bLI6088_bli_crearcuentacorriente;
	}
	public void unsetBLI6088_bli_crearcuentacorriente(com.cobiscorp.designer.bli.api.IBLIExecutor bLI6088_bli_crearcuentacorriente) {
		this.bLI6088_bli_crearcuentacorriente = null;
	}
	@Override
	public void executeCommand(DynamicRequest arg0, IExecuteCommandEventArgs arg1) {
		try {
			iExecuteCommandVA_VABUTTONULIEIHJ_661726.executeCommand(arg0, arg1);
			bLI6088_bli_crearcuentacorriente.execute(arg0);
		} catch (Exception ex) {
			arg1.setSuccess(false);
			DesignerManagerException.handleException(arg1.getMessageManager(), ex, logger);
		}
	}


	@Override
	public void configure() {
        this.addExecuteCommandEvent("VA_VABUTTONULIEIHJ_661726", this);
	}

}

