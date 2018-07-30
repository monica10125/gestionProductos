package com.entidades;

import com.entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-22T12:58:23")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> nombreCliente;
    public static volatile SingularAttribute<Cliente, String> apellidosCliente;
    public static volatile SingularAttribute<Cliente, String> tipoIdentiicacionCliente;
    public static volatile ListAttribute<Cliente, Pedido> pedidoList;
    public static volatile SingularAttribute<Cliente, Integer> secuenciaCliente;
    public static volatile SingularAttribute<Cliente, String> numeroIdentificacionCliente;
    public static volatile SingularAttribute<Cliente, String> telefonoContacto;
    public static volatile SingularAttribute<Cliente, String> correoElectronicoCliente;

}