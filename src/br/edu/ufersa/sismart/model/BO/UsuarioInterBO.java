package br.edu.ufersa.sismart.model.BO;

import br.edu.ufersa.sismart.exception.AutenticationException;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;

public interface UsuarioInterBO<VO extends UsuarioVO> extends BaseInterBO<VO> {
	public UsuarioVO autenticar (VO vo) throws AutenticationException;
}
