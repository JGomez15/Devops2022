package mx.tecnm.piedad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.tecnm.piedad.dao.CuentaJDBC;
import mx.tecnm.piedad.models.Cuenta;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class CuentaWS {
	
	@Autowired
	CuentaJDBC repo;
	
	@PostMapping("/planes/{id}/cuentas")
	public ResponseEntity<?> insertar(@RequestBody Cuenta nueva_cuenta, @PathVariable int id){
		try {
			repo.insertar(nueva_cuenta, id);
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
