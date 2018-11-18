package sis.nucleo.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sis.nucleo.it.dao.PruebaRepository;
import sis.nucleo.it.entitys.Cuenta;

//@Component
@Service("pruebaService")
public class PruebaServiceImpl implements PruebaService {

	@Autowired
	PruebaRepository pruebaRepository;


	@Transactional(readOnly = true)
	public String message() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SERVICE message LLEGO AL SERVICE ");
		return pruebaRepository.messageRepository();
	}

	// @Transactional(readOnly = true)
	// public List<Cuenta> lstUser() throws Exception {
	// // TODO Auto-generated method stub
	// System.out.println("SERVICE M:lstUser LLEGO AL SERVICE ");
	// return pruebaRepository.lstUser();
	// }

}
