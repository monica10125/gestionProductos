package com.entidades;

import com.entidades.Categoria;
import com.entidades.SolicitudPedido;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-22T12:58:23")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, BigInteger> codigoBarra;
    public static volatile SingularAttribute<Producto, Integer> secuenciaProducto;
    public static volatile SingularAttribute<Producto, Integer> cantidadStock;
    public static volatile SingularAttribute<Producto, Integer> estadoProducto;
    public static volatile SingularAttribute<Producto, Categoria> fkSecuenciaCategoria;
    public static volatile SingularAttribute<Producto, String> descripcionProducto;
    public static volatile SingularAttribute<Producto, Integer> precioProducto;
    public static volatile ListAttribute<Producto, SolicitudPedido> solicitudPedidoList;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}