package mx.tecnm.piedad.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.tecnm.piedad.models.Cuenta;

@Repository

public class CuentaJDBC {
	
	@Autowired
	JdbcTemplate conexion;
	
	public int insertar(Cuenta nueva_cuenta, int id) {
		String sql = "INSERT INTO cuentas(email, password, nombre, apellido, numero_tarjeta, "
				+ "fecha_vencimiento, codigo_seguridad, tipo_tarjeta_id, planes_id) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		conexion.update(sql, nueva_cuenta.getEmail(), nueva_cuenta.getPassword(), nueva_cuenta.getNombre(),
				nueva_cuenta.getApellido(), nueva_cuenta.getNumero_tarjeta(), nueva_cuenta.getFecha_vencimiento(),
				nueva_cuenta.getCodigo_seguridad(), nueva_cuenta.getTipo_tarjeta_id(), id);
		sql = "SELECT LAST_INSERT_ID()";
		return conexion.queryForObject(sql, Integer.class);
	}
	
	public void desactivar(int id) {
		String sql = "UPDATE cuentas SET activa = 0 WHERE id = ?";
		conexion.update(sql, id);
	}
}
