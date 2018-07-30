package com.entidades;

import com.entidades.Pedido;
import com.entidades.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-22T12:58:23")
@StaticMetamodel(SolicitudPedido.class)
public class SolicitudPedido_ { 

    public static volatile SingularAttribute<SolicitudPedido, Integer> secuenciaSolicitudProducto;
    public static volatile SingularAttribute<SolicitudPedido, Producto> fkSecuenciaProducto;
    public static volatile SingularAttribute<SolicitudPedido, Integer> cantidadProducto;
    public static volatile SingularAttribute<SolicitudPedido, Pedido> fkSecuenciaPedido;

}