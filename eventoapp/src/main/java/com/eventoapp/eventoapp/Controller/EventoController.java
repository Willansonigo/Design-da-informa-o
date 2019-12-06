package com.eventoapp.eventoapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Controller//Uma anotação do controller.
public class EventoController {//Controller aqui controlo os botões da view sem codificar na view somente no Controller dela.
    
	@Autowired//Ela faz uma injeção de dependencias,toda vez que for usar essa interface,ela vai criar uma nova instância
	private EventoRepository er;
	
	@RequestMapping(value="/CadastrarEvento" , method=RequestMethod.GET)//"/cadastrarEvento")
	public String form() {//Um metodo que vai retornar um formulario.
	  
		return "evento/FormEvento";
	
	}

	@RequestMapping(value="/CadastrarEvento" , method=RequestMethod.POST)//Na hora que apertar o botão salvar os dados, ele vai mandar para essa requisição onde vai salvar os dados no banco de dados.
	public String form(Evento evento) {//Um metodo que vai retornar um formulario.
	  
		er.save(evento);//Com isso ele vai salvar esse evento no banco de dados.
		
		return "redirect:/CadastrarEvento";

	}
    
	@RequestMapping("/eventos")
	public ModelAndView ListaEventos() {//Mostrar a pagina com objeto junto
		
		ModelAndView mv = new ModelAndView("index");//Index é a pagina que será renderizada porque ela esta pronta para receber os dados.
	    Iterable<Evento> eventos = er.findAll();//Não axatamente na LIST,pois é o java 8.findAll =  select * from.Eele busca todas as listas de eventos.
	    mv.addObject("eventos", eventos);
	    return mv;
	}
	
	}
