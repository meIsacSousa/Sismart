package br.edu.ufersa.sismart.model.BO;

import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.exception.NotFoundException;

public abstract class BaseBO<VO> implements BaseInterBO<VO> {

	public abstract void cadastrar(VO vo) throws InsertException;
	public abstract void deletar(VO vo) throws InsertException;
	public abstract void alterar(VO vo) throws InsertException;
	public abstract List<VO> listar(VO vo) throws InsertException;
	public abstract VO buscarPorId(VO vo) throws NotFoundException;
}
