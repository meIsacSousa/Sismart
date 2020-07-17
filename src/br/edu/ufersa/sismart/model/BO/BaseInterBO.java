package br.edu.ufersa.sismart.model.BO;

import br.edu.ufersa.sismart.exception.InsertException;

public interface BaseInterBO<VO> {
	public void cadastrar(VO vo) throws InsertException;
	public void deletar(VO vo) throws InsertException;
	public void alterar(VO vo) throws InsertException;
	public void remover(VO vo) throws InsertException;
}
