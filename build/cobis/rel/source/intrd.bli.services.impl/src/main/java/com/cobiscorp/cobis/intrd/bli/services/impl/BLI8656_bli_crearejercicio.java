package com.cobiscorp.cobis.intrd.bli.services.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.cobiscorp.cobis.cwc.context.MapperManager;
import com.cobiscorp.cobis.cwc.kernel.sp.dto.MapperResult;
import com.cobiscorp.cobis.cwc.kernel.sp.impl.ExecutorSP;

import com.cobiscorp.cobis.intrd.model.CuentaAhorro;

import com.cobiscorp.designer.api.DataEntity;
import com.cobiscorp.designer.api.DataEntityList;
import com.cobiscorp.designer.api.DynamicRequest;
import com.cobiscorp.designer.bli.util.BLIUtils;
import com.cobiscorp.designer.bli.api.IBLIExecutor;
import com.cobiscorp.designer.exception.DesignerRuntimeException;
import com.cobiscorp.designer.bli.manager.BliManagerException;
import com.cobiscorp.cobis.cwc.server.information.ServerParamUtil;
import com.cobiscorp.cobis.commons.domains.log.ILogger;
import com.cobiscorp.cobis.commons.log.LogFactory;
import com.cobiscorp.ecobis.map.Mapper;
import com.cobiscorp.ecobis.map.dto.Result;
import com.cobiscorp.ecobis.map.enums.SqlType;

@Component
@Service({ IBLIExecutor.class })
@Properties({
  @Property(name = "task.module", value = "INTRD"),
  @Property(name = "bli.id", value = "BLI8656_bli_crearejercicio")
})
public class BLI8656_bli_crearejercicio implements IBLIExecutor {
  private static final ILogger logger = LogFactory.getLogger(BLI8656_bli_crearejercicio.class);

  public void execute(DynamicRequest dynamicRequest) {
    Mapper mapper = null;
    try {
      DataEntity row = BLIUtils.getRowDataEntity(dynamicRequest);
      List<Object> outListEntities = new ArrayList<Object>();
      DataEntity rowCuentaAhorro;
      if (row != null && CuentaAhorro.ENTITY_NAME.equals(row.getEntityName())) {
        rowCuentaAhorro = row;
      } else {
        rowCuentaAhorro = BLIUtils.getDataEntity(dynamicRequest, CuentaAhorro.ENTITY_NAME);
        if (rowCuentaAhorro == null) {
          throw new DesignerRuntimeException("No existe entidad " + CuentaAhorro.ENTITY_NAME);
        }
      }

      Integer wcaCliente = rowCuentaAhorro.get(CuentaAhorro.CACLIENTE);
      Double wcaSaldo = rowCuentaAhorro.get(CuentaAhorro.CASALDO);

      if (logger.isDebugEnabled()) {
        logger.logDebug("inputParameters: " + " CACLIENTE: " + wcaCliente + " CASALDO: " + wcaSaldo);
      }

      mapper = MapperManager.get(Mapper.class);
      mapper.addInputParameter("@t_trn", SqlType.INT, "");
      mapper.addInputParameter("@i_operacion", SqlType.CHAR, "I");

      if (wcaCliente != null){
        mapper.addInputParameter("@i_ca_cliente", SqlType.INT, BLIUtils.convertToType(wcaCliente, String.class));
      }

      if (wcaSaldo != null){
        mapper.addInputParameter("@i_ca_saldo", SqlType.MONEY, BLIUtils.convertToType(wcaSaldo, String.class));
      }
      boolean ret = mapper.execute(".cobis.g6_sp_cuenta_ahorros");
      int retCode = mapper.returnCode();
      if (ret && (retCode == 0)) {




        if (logger.isDebugEnabled()) {
          logger.logDebug("returnCode: " + retCode);
        }
      } else {
        BliManagerException.handleMapperException(mapper);
      }
    } catch (Exception ex) {
      BliManagerException.handleBliException(ex);
    } finally {
      if (mapper != null)
        mapper.check();
    }
  }

}
