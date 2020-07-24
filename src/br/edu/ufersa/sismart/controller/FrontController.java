package br.edu.ufersa.sismart.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.edu.ufersa.sismart.exception.AutenticationException;
import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.BO.ItemBO;
import br.edu.ufersa.sismart.model.VO.TipoVO;
import br.edu.ufersa.sismart.model.BO.TipoBO;
import br.edu.ufersa.sismart.model.BO.UsuarioBO;
import br.edu.ufersa.sismart.model.BO.UsuarioInterBO;
import br.edu.ufersa.sismart.model.VO.FuncionarioVO;
import br.edu.ufersa.sismart.model.VO.GerenteVO;
import javafx.fxml.Initializable;
import br.edu.ufersa.sismart.model.VO.UsuarioVO;
import br.edu.ufersa.sismart.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FrontController implements Initializable{
	UsuarioInterBO<UsuarioVO> usuBO = new UsuarioBO<UsuarioVO>();
	ObservableList<String> pesquisarPorList = FXCollections.
			observableArrayList("Nome", "Marca", "Codigo");
	
	//Componentes Tela de Login
	@FXML
	private Label erroLogin;
	@FXML
	private TextField email;
	@FXML
	private TextField senha;
	
	//Componentes Tela Cadastro de Itens
	@FXML
	private TextField nome;
	@FXML
	private TextField marca;
	@FXML 
	private TextField codigoDeBarras;
	@FXML
	private TextField quantidadeEmEstoque;
	@FXML 
	private TextField tipo;
	@FXML 
	private TextField preco;
	
	//componentes tela cadastro de Tipos
	@FXML 
	private TextField nomeTipo;
	@FXML
	private TextField formaDeVenda;
	
	//componentes tabela de itens do gerente
	@FXML
	private TableView<ItemVO> tabelaItens;
	@FXML
	private TableColumn<Integer, ItemVO> colQtd;
	@FXML 
	private TableColumn<ItemVO, String> colProduto;
	@FXML 
	private TableColumn<ItemVO, String> colMarca;
	@FXML 
	private TableColumn<ItemVO, Integer> colEstoque;
	@FXML 
	private TableColumn<ItemVO, Integer> colTipo;
	@FXML 
	private TableColumn<ItemVO, Double> colPreco;

	

	//componente choicebox da pesquisa
	@FXML
	private ChoiceBox<String> pesquisarPor;
	

	public void cadastrarItem(ActionEvent event) throws Exception {
		ItemVO vo = new ItemVO();
		ItemBO bo = new ItemBO();
		TipoVO tVO = new TipoVO();
		TipoBO tBO = new TipoBO();
		
		vo.setNome(nome.getText());
		vo.setMarca(marca.getText());
		vo.setCodigoDeBarras(codigoDeBarras.getText());
		vo.setQuantidadeEmEstoque(Integer.parseInt(quantidadeEmEstoque.getText()));
		vo.setPreco(Double.parseDouble(preco.getText()));
		vo.setIdCesta(3);
		
		tVO = tBO.buscarPorId(Long.parseLong(tipo.getText()));
		vo.setTipo(tVO);
		bo.cadastrar(vo);
	}
	
	public void cadastrarTipo(ActionEvent event) throws Exception {
		TipoVO vo = new TipoVO();
		TipoBO bo = new TipoBO();
		vo.setNome(nomeTipo.getText());
		vo.setFormaDeVenda(formaDeVenda.getText());
		bo.cadastrar(vo);
	}

	public void alterarItem(ActionEvent event) throws Exception {

	}

	public void autenticar(ActionEvent event) throws Exception {
		UsuarioVO vo = new UsuarioVO();
		try {
			vo.setLogin(email.getText());
			vo.setSenha(senha.getText());
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			UsuarioVO autenticado = usuBO.autenticar(vo);
			if (autenticado instanceof GerenteVO) {
				Telas.telaInicialGerente();
			} else {
				Telas.telaInicialFuncionario();
			}
		} catch (AutenticationException e) {
			erroLogin.setText("Usuário ou senha inválidos");
			erroLogin.setVisible(true);
		}
	}
	
	public void initTable() throws InsertException {
		System.out.println(colQtd);
		System.out.println(colProduto);
		System.out.println(colMarca);
		System.out.println(colEstoque);
		System.out.println(colTipo);
		System.out.println(colPreco);
		System.out.println(tabelaItens);
		ItemBO iBO = new ItemBO();
		tabelaItens.setItems(FXCollections.observableArrayList(iBO.listar()));
		System.out.println("Chegou aqui");
		colQtd.setCellValueFactory(new PropertyValueFactory<>("quantidadeCompra"));
		System.out.println("Passou de quantidade");
		colProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		colEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEmEstoque"));
		colTipo.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));
		colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
	
	}
	
	public void goToCadastrarItem(ActionEvent event) throws Exception {
		Telas.telaCadastroItens();
	}
	
	public void goToCadastrarTipo(ActionEvent event) throws Exception {
		Telas.telaCadastroTipos();
	}
	
	public void pesquisarPor(MouseEvent event) throws Exception {
		pesquisarPor.setItems(pesquisarPorList);
	}
	
	public void receberPesquisa(ActionEvent event) throws Exception {
		
	}
	
	public void pesquisar(ActionEvent event) throws Exception {

	}
	
	public void voltar(ActionEvent event) throws Exception {
		Telas.telaInicialGerente();
	}
	
	public void voltarFunc(ActionEvent event) throws Exception {
		Telas.telaInicialFuncionario();
	}
	
	public void sair(ActionEvent event) throws Exception {
		Telas.telaLogin();
	}
	
	public void goToCesta(MouseEvent event) throws Exception {
		Telas.telaCesta();
	}
	public void goToCestaFunc(MouseEvent event) throws Exception {
		Telas.telaCestaFunc();
	}
	public void gerarNota(ActionEvent event) throws Exception {
		Telas.telaNota();
	}
	public void gerarNotaFunc(ActionEvent event) throws Exception {
		Telas.telaNotaFunc();
	}
	public void voltarCesta(ActionEvent event) throws Exception {
		Telas.telaCesta();
	}
	public void voltarCestaFunc(ActionEvent event) throws Exception {
		Telas.telaCestaFunc();
	}
	public void imprimirNota(ActionEvent event) throws Exception {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			initTable();
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
