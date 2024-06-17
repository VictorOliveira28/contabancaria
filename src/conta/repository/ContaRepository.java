package conta.repository;

import conta.model.ModelConta;

public interface ContaRepository {

	// CRUD da Conta
		public void procurarPorNumero(int numero);
		public void listarTodas();
		public void cadastrar(ModelConta conta);
		public void atualizar(ModelConta conta);
		public void deletar(int numero);
		
		// Métodos Bancários
		public void sacar(int numero, float valor);
		public void depositar(int numero, float valor);
		public void transferir(int numeroOrigem, int numeroDestino, float valor);
}
