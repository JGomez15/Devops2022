package mx.tecnm.piedad.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.piedad.models.Cuenta;

public class CuentaRM implements RowMapper<Cuenta>{

	//Referencia la creacion de los atributos de Cuenta.java existente en los Modelos
	//a los atributos de la tabla en Workbench
	@Override
	public Cuenta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cuenta cuenta = new Cuenta();
		cuenta.setId(rs.getInt("id"));
		cuenta.setEmail(rs.getString("email"));
		cuenta.setPassword(rs.getString("password"));
		cuenta.setActiva(rs.getInt("activa"));
		cuenta.setFecha_ultimo_pago(rs.getString("fecha_ultimo_dato"));
		cuenta.setNombre(rs.getString("nombre"));
		cuenta.setApellido(rs.getString("apellido"));
		cuenta.setNumero_tarjeta(rs.getString("numero_tarjeta"));
		cuenta.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
		cuenta.setCodigo_seguridad(rs.getString("codigo_seguridad"));
		cuenta.setTipo_tarjeta_id(rs.getInt("tipo_tarjeta_id"));
		cuenta.setPlanes_id(rs.getInt("planes_id"));
		return null;
	}
	
}
