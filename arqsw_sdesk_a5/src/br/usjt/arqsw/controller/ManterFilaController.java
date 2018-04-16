package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.FilaService;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */

@Controller
@Transactional
public class ManterFilaController {
	private FilaService filaService;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	public ManterFilaController(FilaService filaService) {
		this.filaService = filaService;
	}

	private List<Fila> listarFilas() throws IOException {
		return filaService.listarFilas();
	}

	@RequestMapping("/listar_filas")
	public String listarFilasExibir(Model model) {
		try {
			List<Fila> filas = listarFilas();
			model.addAttribute("filas", filas);
			return "FilaListarExibir";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping(value = "/criar_fila", method = RequestMethod.GET)
	public String fila() {
		return "FilaCriar";
	}

	@RequestMapping(value = "/salvar_fila", method = RequestMethod.POST)
	public String salvarFila(@Valid Fila fila, Model model, @RequestParam("file") MultipartFile file) {
		try {
			Fila filaCriada = filaService.salvar(fila);
			filaService.gravarImagem(servletContext, filaCriada, file);
			model.addAttribute("fila", filaCriada);

			return "FilaCriada";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping(value = "/atualizar_fila", method = RequestMethod.POST)
	public String atualizarFila(@Valid Fila fila, Model model, @RequestParam("file") MultipartFile file) {
		try {
			Fila filaAtualizada = filaService.atualizar(fila);
			filaService.gravarImagem(servletContext, filaAtualizada, file);

			return "redirect:listar_filas";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping(value = "/alterar_fila", method = RequestMethod.GET)
	public String alterarFila(@RequestParam("id") Integer id, Model model) {
		try {
			Fila fila = filaService.carregar(id);
			model.addAttribute("fila", fila);
			return "FilaAlterar";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping("/excluir_fila")
	public String excluirFila(@RequestParam("id") int id, Model model) {
		try {
			model.addAttribute("id", filaService.excluir(id));
			return "FilaExcluida";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}

	@RequestMapping(value = "/detalhes_fila", method = RequestMethod.GET)
	public String detalhesFila(@RequestParam("id") Integer id, Model model) {
		try {
			Fila fila = filaService.carregar(id);
			model.addAttribute("fila", fila);
			return "FilaDetalhes";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
}
