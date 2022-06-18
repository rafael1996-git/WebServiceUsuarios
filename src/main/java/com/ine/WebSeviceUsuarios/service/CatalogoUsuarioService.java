package com.ine.WebSeviceUsuarios.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.logging.Logger;
import org.jboss.resteasy.logging.impl.Log4jLogger;

import com.ine.WebSeviceUsuarios.dao.DataBaseConnection;
import com.ine.WebSeviceUsuarios.dto.ResponseOK;
import com.ine.WebSeviceUsuarios.dto.Usuarios;





@Path("PrefUsuario")
public class CatalogoUsuarioService {

	Logger logger = Log4jLogger.getLogger(CatalogoUsuarioService.class);
	private DataBaseConnection db;
	ResponseOK respuesta = new ResponseOK();
	@GET
	@Path("/")
	@Produces("application/json")
	public ResponseOK getUsuarios() throws Exception {
		
		List<Usuarios> user = db.getConsultaDAO();
		if (user != null) {
			if (user.isEmpty()) {
				respuesta.setEstatus(02);
				respuesta.setResultado(user);
				respuesta.setMsj("Operacion Exitosa: no se encontro registro");
				 System.out.println( "Hello World02!"+respuesta );
			} else if (user.size() == 1) {
				respuesta.setEstatus(03);
				respuesta.setResultado(user);
				respuesta.setMsj("Operacion Exitosa: solo se encontro un registro");
				 System.out.println( "Hello World03!"+respuesta );
			} else {
				respuesta.setEstatus(04);
				respuesta.setResultado(user);
				respuesta.setMsj("Operacion Exitosa");
				 System.out.println( "Hello World!04"+respuesta );
			}

		} else {
			respuesta.setEstatus(01);
			respuesta.setMsj(Response.serverError().toString());
		}
		return respuesta;
	}
	
}
