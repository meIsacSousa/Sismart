package br.edu.ufersa.sismart.model.BO;

import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;

public interface BaseInterBO<VO> {
	public void cadastrar(VO vo) throws InsertException;
	public void deletar(VO vo) throws InsertException;
	public void alterar(VO vo) throws InsertException;
	public List<VO> listar(VO vo) throws InsertException;
	public VO buscarPorId(VO vo) throws NotFoundException;
}
