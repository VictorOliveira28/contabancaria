package conta.controller;

import java.util.ArrayList;

import conta.model.ContaModel;
import conta.repository.ContaRepository;


public class ContaController implements ContaRepository{

	private ArrayList<ContaModel> listaContas = new ArrayList<ContaModel>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.visualizar();
		}else {
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		}
		
		
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(ContaModel conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(ContaModel conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else {
			System.out.println("\nA Conta numero: " + conta.getNumero() + " não foi encontrada!");
		}
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			if(listaContas.remove(conta)) {
				System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso");
			} else {
				System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
			}
		} else {
			System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	public int gerarNumero() {
		return ++ numero;
	}
	
	public ContaModel buscarNaCollection(int numero) {
		
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}
	

}
