package sis.nucleo.it.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sis.nucleo.it.entitys.Cuenta;

//@Component
@Repository("pruebaRepository")
public abstract class PruebaRepositoryImpl implements PruebaRepository {

	// @Autowired
	// private DataSource dataSource;

	Connection con = null;

	@Transactional(readOnly = true)
	public String messageRepository() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DAO IMPL TAMAÑO DE MENSAJEE: ");
		return "HOLA";
	}

	
	// @Transactional(readOnly = true)
	// public List<Cuenta> lstUser() throws Exception {
	// // TODO Auto-generated method stub
	// System.out.println("************START M:LSTUSER*************");
	// System.out.println("DAO IMPL TAMAÑO DE LISTA: ");
	// System.out.println("******************************************");
	// List<Cuenta> lst = new ArrayList();
	// con = dataSource.getConnection();
	// StringBuilder sb = new StringBuilder();
	// sb.append(" SELECT CUENTA_ID, ");
	// sb.append(" NOMBRES, ");
	// sb.append(" APE_PAT, ");
	// sb.append(" APE_MAT ");
	// sb.append(" FROM CUENTA ");
	// Statement stm = this.con.createStatement();
	// ResultSet rs = stm.executeQuery(sb.toString());
	// Cuenta cuenta;
	// while (rs.next()) {
	// cuenta = new Cuenta();
	// cuenta.setCuentaId(rs.getLong(1));
	// cuenta.setNombre(rs.getString(2));
	// cuenta.setApellidos(rs.getString(3) + " " + rs.getString(4));
	// lst.add(cuenta);
	// System.out.println("VALUE: " + cuenta.getApellidos());
	// }
	// System.out.println("DAO IMPL TAMAÑO DE LISTA: " + lst);
	// System.out.println("************END M:LSTUSER*************");
	// System.out.println("END DAO IMPL TAMAÑO DE LISTA: ");
	// System.out.println("******************************************");
	// return lst;
	// }

}
