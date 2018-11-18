package sis.nucleo.it.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sis.nucleo.it.constantes.Constantes;
import sis.nucleo.it.model.Cuenta;
import sis.nucleo.it.model.ResponCod;
import sis.nucleo.it.model.Usuario;
import sis.nucleo.it.service.PruebaService;
import sis.nucleo.it.service.ServiceAccesoCuenta;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger logger = LoggerFactory
			.getLogger(GreetingController.class);
    
    @Autowired
	PruebaService pruebaService;
   
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
	@RequestMapping(value = Constantes.DUMMY_EMP, method = RequestMethod.GET)
	public @ResponseBody
	List<Usuario> getDataPrueba() {
		logger.info("Start getDummyEmployee");
		List<Usuario> list = new ArrayList<Usuario>();
		Usuario row = null;
		for (int i = 0; i < 10000; i++) {
			row = new Usuario();
			row.setName("Usuario" + " " + String.valueOf(i));
			row.setIdUsuario(String.valueOf(i));
			row.setApaterno("xpater" + " " + String.valueOf(i));
			row.setAmaterno("xmater" + " " + String.valueOf(i));
			list.add(row);
		}
		return list;

	}
	
	@RequestMapping(value = Constantes.ACCES, method = RequestMethod.GET)
	public @ResponseBody
	String AccesCuenta() throws Exception {
		System.out.println("************STAR*************");
		System.out.println("CONTROLER M:AccesCuenta LLEGO AL CONTROLLER ");
		System.out.println("******************************************");

		return pruebaService.message();
	}

	
//	@RequestMapping(value = Constantes.GET_LST, method = RequestMethod.GET)
//	public @ResponseBody
//	List<sis.nucleo.it.entitys.Cuenta> lstUser() throws Exception {
//		System.out.println("************START M:LSTUSER*************");
//		System.out.println("CONTROLER M:lstUser LLEGO AL CONTROLLER ");
//		System.out.println("******************************************");
//		return pruebaService.lstUser();
//	}
	
}
