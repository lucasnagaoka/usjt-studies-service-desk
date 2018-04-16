package br.usjt.arqsw.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.usjt.arqsw.dao.FilaDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */

@Service
public class FilaService {
	private FilaDAO dao;
	private ChamadoService chamadoService;

	@Autowired
	public FilaService(FilaDAO dao, ChamadoService chamadoService) {
		this.dao = dao;
		this.chamadoService = chamadoService;
	}

	public List<Fila> listarFilas() throws IOException {
		return dao.listarFilas();
	}

	public Fila carregar(int id) throws IOException {
		return dao.carregar(id);
	}

	public Fila salvar(Fila fila) throws IOException {
		return dao.salvar(fila);
	}
	
	public Fila atualizar(Fila fila) throws IOException {
		return dao.atualizar(fila);
	}

	public void gravarImagem(ServletContext servletContext, Fila fila, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			String path = servletContext.getRealPath(servletContext.getContextPath());
			path = path.substring(0, path.lastIndexOf('/'));
			String nomeArquivo = "img" + fila.getId() + ".jpg";
			fila.setCaminhoFigura(nomeArquivo);

			salvar(fila);
			File destination = new File(path + File.separatorChar + "img" + File.separatorChar + nomeArquivo);
			if (destination.exists()) {
				destination.delete();
			}
			ImageIO.write(src, "jpg", destination);
		}
	}

	public int excluir(int id) throws IOException {
		Fila fila = carregar(id);

		List<Chamado> chamados = chamadoService.listarChamados(fila);

		if (chamados.isEmpty()) {
			dao.excluir(fila);
			return id;
		} 
		
		return -1;
//		else {
//			for (Chamado chamado : chamados) {
//				if(chamado.getStatus().equals("aberto")) {
//					break;
//				}
//			}
//			dao.excluir(fila);
//			return id;
//		}
	}
}
