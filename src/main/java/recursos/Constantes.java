/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author pc lenovo
 */
public enum Constantes {
    
   ROLADMINISTRADOR("administrador")
   ,ROLCLIENTE ("cliente")
   ,LOGININCONRRECTO("Usuario y clave incorrectas")
   ,ERRORINICIOSESION("Se produjo un error iniciando sesión consulte con el administrador del sistema el error")
   ,SESIONUSER("usuario")
   ,ERRORESSESION("Se produjo un error obteniendo la sesion")
   ,ERRORGENERAL("Se produjo un error procesando su solicitud, si el error persiste por favor contante con el administrador  ")
   ,ERRORCARGUE("Se produjo un error cargando los datos");
    
   private String tipoRol; 

    private Constantes(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getTipoRol() {
        return tipoRol;
    }

  
}    
   

