package sis.nucleo.it.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sis.nucleo.it.constantes.UtilsConsultas;
import sis.nucleo.it.model.Cliente;
import sis.nucleo.it.model.Cuenta;
import sis.nucleo.it.model.ResponCod;


@Repository
public class implLoginCuenta implements LoginCuenta{
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;	
	Connection con=null;
	 @Transactional
	public ResponCod AccesoUser(Cuenta cuenta) {
		ResponCod cod=null;
		try {
			cod=new ResponCod();
			con=dataSource.getConnection();
			CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_AUTENTICACION);  
			cStmt.setString(1, cuenta.getUsuario());	
			cStmt.setString(2, cuenta.getPassword());
			cStmt.registerOutParameter(3, java.sql.Types.DOUBLE);
			cStmt.registerOutParameter(4, java.sql.Types.VARCHAR);			
			cStmt.execute();  
			int indice= cStmt.getInt(3);
			String mensaje=cStmt.getString(4);
			System.out.println("resultado: "+String.valueOf(indice)+"mens:"+mensaje);
			switch(indice){
			case 0:
				cod.setId(String.valueOf(indice));
				cod.setMensaje(mensaje);
				break;
			case 1:
				cod.setId(String.valueOf(indice));
				cod.setMensaje(mensaje);
				break;
				
			case 2:
				cod.setId(String.valueOf(indice));
				cod.setMensaje(mensaje);
				break;
				
					}
		
		}catch(Exception e){
			cod=new ResponCod();
			cod.setId("0");
			cod.setMensaje("Error!!!");
		}

		return cod;
	}
	 @Transactional
	public ResponCod CreateCliente(Cliente cliente) throws Exception {
		// TODO Auto-generated method stub
		ResponCod cod=null;

			cod=new ResponCod();
			con=dataSource.getConnection();
			try{
				CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_CREATE_CUENTA);  
				cStmt.setString(1,cliente.getUsrCuenta());
				cStmt.setString(2,cliente.getPassword());
				cStmt.setString(3,cliente.getName());
				cStmt.setString(4,cliente.getApPaterno());
				cStmt.setString(5, cliente.getApPaterno());
				cStmt.registerOutParameter(6, java.sql.Types.INTEGER);	
				cStmt.registerOutParameter(7, java.sql.Types.VARCHAR);	
				cStmt.execute();
				cod.setId(String.valueOf(cStmt.getInt(6)));
				cod.setMensaje(cStmt.getString(7));
				System.out.println("codigo-->"+cod);
			}catch(Exception e){
				cod.setId("3");
				cod.setMensaje(e.getMessage());
			}
		
		return cod;
	}
	 @Transactional
	public int ExistenciaEmail(String email) throws Exception {
		int cod=0;
		con=dataSource.getConnection();
		try{
			CallableStatement cStmt = con.prepareCall(UtilsConsultas.CALL_EXISTENCIA_EMAIL);  
			cStmt.setString(1,email);
			cStmt.registerOutParameter(2, java.sql.Types.INTEGER);		
			cStmt.execute();
			cod=cStmt.getInt(2);
			System.out.println("codigo-->"+cod);
		}catch(Exception e){
			
		}
	
		return cod;
	}

}
