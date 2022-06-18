package com.ine.WebSeviceUsuarios.service;
/**
 * Esta clase contiene el controlador que brinda el servicio con la url de invocacion
 * @author Alejandro Sandoval Rodriguez 
 * @version 1.3.1
 * 
 */
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.ine.WebSeviceUsuarios.dao.DataBaseConnection;
import com.ine.WebSeviceUsuarios.dto.ResponseOK;
import com.ine.WebSeviceUsuarios.dto.Usuarios;


@Path("PrefUsuario")
public class CatalogoUsuariosIdService {
	
	  /**
     * Metodo getMunicipio es un tipo GET que devuelve la lista de municipio
     * URL: http://localhost:8080/geolocmunicipio/services/CMunicipios/idEntidad/9 
     * @param id del municipio
     * @throw atrapa el error en caso de no devolver la lista en caso de no hacer conexion a la base de datos
     * 
     */
	@GET
	@Path("/idEntidad/{id_usuario}")
	@Produces("application/json")
	public ResponseOK getMunicipio(@PathParam("id_usuario") int id_usuario) throws Exception {
		DataBaseConnection db = new DataBaseConnection();
		com.ine.WebSeviceUsuarios.dto.ResponseOK reponse = new com.ine.WebSeviceUsuarios.dto.ResponseOK();
		if (id_usuario == 0) {
			reponse.setEstatus(00);
			reponse.setMsj(Response.status(Response.Status.BAD_REQUEST).build().toString());
		}
		List<?> municipio = db.getConsultaDAO2(id_usuario);

		if (municipio != null) {
			if (municipio.isEmpty()) {
				reponse.setEstatus(02);
				reponse.setResultado(municipio);
				reponse.setMsj("Operacion Exitosa: no se encontro registro");
			} else if (municipio.size() == 1) {
				reponse.setEstatus(03);
				reponse.setResultado(municipio);
				reponse.setMsj("Operacion Exitosa: solo se encontro un registro");
			} else {
				reponse.setEstatus(04);
				reponse.setResultado(municipio);
				reponse.setMsj("Operacion Exitosa");
			}

		} else {
			reponse.setEstatus(01);
			reponse.setMsj(Response.serverError().toString());
		}
		 /**
	     * 
	     * @return Regresa una lista de municipio en objeto response
	     */
		return reponse;
	}

}
