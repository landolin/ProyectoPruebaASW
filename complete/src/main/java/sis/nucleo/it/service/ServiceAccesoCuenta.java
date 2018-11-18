package sis.nucleo.it.service;

import sis.nucleo.it.model.Cliente;
import sis.nucleo.it.model.Cuenta;
import sis.nucleo.it.model.ResponCod;



public interface ServiceAccesoCuenta {
	public ResponCod AccesoUser(Cuenta cuenta) throws Exception;
	public ResponCod CreateCliente(Cliente user) throws Exception;
	public ResponCod ExistenciEmailServis(String email) throws Exception;
}
