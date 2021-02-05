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

import com.cobiscorp.cobis.intrd.model.Producto;

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
  @Property(name = "bli.id", value = "BLI9274_bli_crearproducto")
})
public class BLI9274_bli_crearproducto implements IBLIExecutor {
  private static final ILogger logger = LogFactory.getLogger(BLI9274_bli_crearproducto.class);

  public void execute(DynamicRequest dynamicRequest) {
    Mapper mapper = null;
    try {
      DataEntity row = BLIUtils.getRowDataEntity(dynamicRequest);
      List<Object> outListEntities = new ArrayList<Object>();
      DataEntity rowProducto;
      if (row != null && Producto.ENTITY_NAME.equals(row.getEntityName())) {
        rowProducto = row;
      } else {
        rowProducto = BLIUtils.getDataEntity(dynamicRequest, Producto.ENTITY_NAME);
        if (rowProducto == null) {
          throw new DesignerRuntimeException("No existe entidad " + Producto.ENTITY_NAME);
        }
      }

      String wtipoh = rowProducto.get(Producto.TIPOH);
      Integer wmodo = rowProducto.get(Producto.MODO);
      Integer widProducto = rowProducto.get(Producto.IDPRODUCTO);
      String wdescripcion = rowProducto.get(Producto.DESCRIPCION);
      Character wtipo = rowProducto.get(Producto.TIPO);
      Character wabreviatura = rowProducto.get(Producto.ABREVIATURA);
      Character westado = rowProducto.get(Producto.ESTADO);
      Double wsaldoMinimo = rowProducto.get(Producto.SALDOMINIMO);
      Double wcosto = rowProducto.get(Producto.COSTO);
      Integer wformatoFecha = rowProducto.get(Producto.FORMATOFECHA);

      if (logger.isDebugEnabled()) {
        logger.logDebug("inputParameters: " + " TIPOH: " + wtipoh + " MODO: " + wmodo + " IDPRODUCTO: " + widProducto + " DESCRIPCION: " + wdescripcion + " TIPO: " + wtipo + " ABREVIATURA: " + wabreviatura + " ESTADO: " + westado + " SALDOMINIMO: " + wsaldoMinimo + " COSTO: " + wcosto + " FORMATOFECHA: " + wformatoFecha);
      }

      mapper = MapperManager.get(Mapper.class);
      mapper.addInputParameter("@t_trn", SqlType.SMALLINT, "1519");
      mapper.addInputParameter("@i_operacion", SqlType.CHAR, "I");

      if (wtipoh != null){
        mapper.addInputParameter("@i_tipo_h", SqlType.CHAR, BLIUtils.convertToType(wtipoh, String.class));
      }

      if (wmodo != null){
        mapper.addInputParameter("@i_modo", SqlType.TINYINT, BLIUtils.convertToType(wmodo, String.class));
      }

      if (widProducto != null){
        mapper.addInputParameter("@i_producto", SqlType.TINYINT, BLIUtils.convertToType(widProducto, String.class));
      }

      if (wdescripcion != null){
        mapper.addInputParameter("@i_descripcion", SqlType.VARCHAR, BLIUtils.convertToType(wdescripcion, String.class));
      }

      if (wtipo != null){
        mapper.addInputParameter("@i_tipo", SqlType.CHAR, BLIUtils.convertToType(wtipo, String.class));
      }

      if (wabreviatura != null){
        mapper.addInputParameter("@i_abreviatura", SqlType.CHAR, BLIUtils.convertToType(wabreviatura, String.class));
      }

      if (westado != null){
        mapper.addInputParameter("@i_estado", SqlType.CHAR, BLIUtils.convertToType(westado, String.class));
      }

      if (wsaldoMinimo != null){
        mapper.addInputParameter("@i_saldo_minimo", SqlType.MONEY, BLIUtils.convertToType(wsaldoMinimo, String.class));
      }

      if (wcosto != null){
        mapper.addInputParameter("@i_costo", SqlType.MONEY, BLIUtils.convertToType(wcosto, String.class));
      }

      if (wformatoFecha != null){
        mapper.addInputParameter("@i_formato_fecha", SqlType.INT, BLIUtils.convertToType(wformatoFecha, String.class));
      }
      boolean ret = mapper.execute(".cobis.sp_producto");
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
