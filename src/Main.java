// Importar biblioteca util para usar o scanner e conseguir capturar informa��es digitadas pelo usuario
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Iniciando intera��o com usuario
		System.out.println("=========================");
		System.out.println("Bem vindo ao Javabank $$");
		System.out.println("=========================");
		
		// La�o infinito fica esperando o usuario digitar uma das op��es do menu
		while (true) {
			System.out.println("Escolha uma op��o do Menu:");
			System.out.println("1 - Abrir Minha Conta");
			System.out.println("2 - Sair");
			
			// Instancia a classe Scanner
			Scanner sc = new Scanner(System.in);
			
			//Captura a op��o do usuario
			int opcao = sc.nextInt();
			
			// Verifica se a op��o do usuario foi 1
			if (opcao == 1) {
				// interage com usuario informando a op��o que ele escolheu e solicita dados
				System.out.println("=== Abertura de Contas ===");
				System.out.println("Digite seu nome: (ex. Fulano ou Fulano_de_Tal)");
				
				// Captura nome do cliente - sem espa�os
				String nome = sc.next();
				
				System.out.println("Digite sua renda mensal: ");
				
				// captura a renda do cliente
				double renda = sc.nextDouble();
				
				// Instancia o Cliente
				Cliente c = new Cliente(nome, renda);
				
				// Instancia a Conta Corrente
				Conta cc = new ContaCorrente(c);
				
				// Instancia a Conta Poupan�a
				Conta cp = new ContaPoupanca(c);
				
				//Definindo o Limite da conta, assumi como premissa que o banco libera limite 50% do valor da renda
				double limite = (c.getRenda() * 0.5);
				cc.definirLimite(limite);
				
				//Interage com usuario informando a cria��o da conta e seus dados
				System.out.println("=======================================================");
				System.out.println("Parab�ns, sua conta foi criada com sucesso!! ");
				System.out.println("=======================================================");
				System.out.println("Agencia: "+cc.agencia+" | Conta Corrente: "+cc.numero+" | Poupanca: "+cp.numero+" | Titular: "+c.getNome()+" |");
				
				// Depois da contra criada inicia outro la�o para aguardar o usuario escolher um item do menu
				while (true) {
				
				//Solicitando nova intera��o
				System.out.println("============================================");
				System.out.println("********* Escolha um item do menu: *********");
				System.out.println("============================================");
				System.out.println("1 - Depositar em Conta Corrente");
				System.out.println("2 - Sacar da Conta Corrente");
				System.out.println("3 - Transferir para conta Poupanca");
				System.out.println("4 - Transferir para conta Corrente");
				System.out.println("5 - Consultar Saldo Conta Corrente");
				System.out.println("6 - Consultar Saldo Conta Poupanca");
				System.out.println("7 - Voltar Menu anterior");
				System.out.println("8 - Sair");
				System.out.println("============================================");
				
				// captura a escolha do usuario para o menu II
				int ni = sc.nextInt();
				
				// verifica se a escolha foi 1 para o menu II
				if (ni == 1) {
					// implementa��o para depositar em conta corrente
					System.out.println("===== Deposito em Conta Corrente =====");
					System.out.println("Digite o valor do deposito: ");
					
					// captura o valor do deposito
					double deposito = sc.nextInt();
					
					// verifica se o valor depositado � maior de zero
					if (deposito > 0) {
						// rea�iza do deposito, informa o usuario do sucesso e retorna para o la�o
						cc.depositar(deposito);
						System.out.println("Valor de positado com sucesso: "+deposito);
						System.out.println("============================================");
						continue;
					}
					//Caso o deposito seja valor negativo, informa usuario para digitar valor positivo e retorna para menu II
					System.out.println("Deposito precisa ser um valor positivo");
					System.out.println("============================================");
					continue;
				
					//	verifica se a op��o foi 2
				}else if (ni == 2) {
					// implementa��o para sacar da conta corrente
					System.out.println("======= Saque de Conta Corrente =======");
					System.out.println("Digite o valor do saque: ");
					
					// captura valor do saque
					double saque = sc.nextInt();
					
					// verifica se o saque � maior que zero e menor ou igual ao saldo mais limite (disponivel)
					if (saque <= (cc.saldo + cc.limite) && saque > 0) {
						// realiza o saque
						cc.sacar(saque);
						
						// informa usuario do sucesso e volta para menu II
						System.out.println("Saque efetuado com sucesso: "+saque);
						System.out.println("============================================");
						continue;
					}
					
					// informa o usuario caso o saque esteja fora das especifica��es
					System.out.println("Valor do saque precisa ser positivo e menor ou igual ao saldo disponivel "+(cc.saldo + cc.limite));
					System.out.println("============================================");
					continue;
					
					// veridica se a op��o do usuario foi 3
				}else if (ni == 3) {
					// implementa transferencia para conta poupan�a
					System.out.println("=== Transferencia para Conta Poupan�a ===");
					System.out.println("Digite o valor a ser Transferido: ");
					// captura valor a ser transferido
					double valorTransf = sc.nextDouble();
					// verifica se tem saldo para transferir
					if (valorTransf <= (cc.saldo + cc.limite)) {
						// execulta a transferencia
						cc.transferir(valorTransf,cp);
						//informa usuario do sucesso e volta para menu II
						System.out.println("Transferencia realizada com sucesso: "+valorTransf);
						System.out.println("==================================");
						continue;
					}
					// informa usuario se n�o houver saldo e volta para menu II
					System.out.println("Valor disponivel para transferencia � "+(cc.saldo + cc.limite));
					System.out.println("============================================");
					continue;
					
					// verifica se a op��o do usuario foi 4
				}else if (ni == 4) {
									
					// implementa transferencia para conta corrente
					System.out.println("=== Transferencia para Conta Corrente ===");
					System.out.println("Digite o valor a ser Transferido: ");
					
					// captura valor da transferencia
					double valorTransfCc = sc.nextDouble();
					
					// Verifica se tem saldo para transferir
					if (valorTransfCc <= cp.saldo) {
						// execulta a transferencia
						cp.transferir(valorTransfCc,cc);
						// informa usuario do sucesso e volta para menu II
						System.out.println("Transferencia realizada com sucesso: "+valorTransfCc);
						System.out.println("==================================");
						continue;
					}
					// informa usuario se n�o houver saldo e volta para menu II
					System.out.println("Valor disponivel para transferencia � "+cp.saldo);
					System.out.println("============================================");
					continue;
					
					// verifica se a escolha do usuario foi 5
				}else if (ni == 5) {
					// execulta consulta de saldo da Conta Corrente
					cc.imprimirExtratoCc();
					System.out.println("==================================");
					
					// verifica se a escolha do usuario foi 6
				}else if (ni == 6) {
					// execulta consulta de saldo da Conta Poupanca
					cp.imprimirExtratoCp();
					System.out.println("==================================");
					
					// verifica se a escolha do usuario foi 7
				}else if (ni == 7) {
					// Retorna ao menu anterior (menu I)
					break;
					
					// verifica se a escolha do usuario foi 8
				}else if (ni == 8) {
					// sair da aplica��o
					System.out.println("Obrigado por usar nosso software, at� logo");
					System.out.println("============================================");
					System.exit(0);
					
					// n�o atendendo criterios anteriores, retorna ao menu I
				}else {
					break;
				}
				
				
				}
				// verifica se a op��o do usuarios foi 2 no menu I
			}else if (opcao == 2) {
				// agradece o usuario e encerra aplica��o
				System.out.println("Obrigado por usar nosso software, at� logo");
				System.out.println("============================================");
				System.exit(0);
				
				// caso usuario digite algo que n�o esta no menu I, orienta a escolher um valor valido
			}else {
				System.out.println("Por favor escolha um valor valido");
				System.out.println("============================================");
				continue;
			}	
			
		}
	}

}
