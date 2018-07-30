package com.entidades;

import com.entidades.Cliente;
import com.entidades.SolicitudPedido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-22T12:58:23")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> fechaCancelacion;
    public static volatile SingularAttribute<Pedido, Integer> costoPedido;
    public static volatile SingularAttribute<Pedido, String> direcionPedido;
    public static volatile SingularAttribute<Pedido, String> ciudadPedido;
    public static volatile SingularAttribute<Pedido, Integer> secuenciaPedido;
    public static volatile SingularAttribute<Pedido, Date> fechaSolicitudPedido;
    public static volatile SingularAttribute<Pedido, Integer> estadoPedido;
    public static volatile ListAttribute<Pedido, SolicitudPedido> solicitudPedidoList;
    public static volatile SingularAttribute<Pedido, Cliente> fkSecuenciaCliente;
    public static volatile SingularAttribute<Pedido, String> departamentoPedido;

}