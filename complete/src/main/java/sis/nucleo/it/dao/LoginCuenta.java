package sis.nucleo.it.dao;

import sis.nucleo.it.model.Cliente;
import sis.nucleo.it.model.Cuenta;
import sis.nucleo.it.model.ResponCod;


public interface LoginCuenta {
	public ResponCod AccesoUser(Cuenta cuenta);
	public ResponCod CreateCliente(Cliente cliente) throws Exception;
	public int ExistenciaEmail(String email) throws Exception;
}
