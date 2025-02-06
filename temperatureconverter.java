package fundamentos;

import java.util.Scanner;

public class Temperatura {

	// Constantes para mensagens de erro, facilitando futuras alterações
	private static final String MENSAGEM_NOME_INVALIDO = ("Nome inválido. Por favor, digite somente letras e espaços.");
	private static final String MENSAGEM_ENTRADA_INVALIDA = ("Entrada inválida. Por favor, digite um número válido para a temperatura.");

	public static void main(String[] args) {

		// Cria um objeto Scanner para ler a entrada do usuário
		Scanner scanner = new Scanner(System.in);

		// Chama o método para obter um nome válido do usuário
		String nome = obterNomeValido(scanner);

		// Exibe uma mensagem de saudação com o nome do usuário
		System.out.println("Olá " + nome + " seja bem-vindo ao conversor de temperatura!");

		// Chama o método para obter uma temperatura válida em Fahrenheit
		double temperaturaFahrenheit = obterTemperaturaValida(scanner);

		// Converte a temperatura de Fahrenheit para Celsius
		double temperaturaCelsius = converterFahrenheitparaCelsius(temperaturaFahrenheit);

		// Exibe o resultado da conversão de temperatura com duas casas decimais
		System.out.printf("%.2f°F equivalem a %.2f°C%n", temperaturaFahrenheit, temperaturaCelsius);

		// Fecha o objeto Scanner para liberar mais recursos
		scanner.close();
	}

	/**
	 * Solicita ao usuário que insira um nome válido, contendo apenas letras e
	 * espaços. Continua solicitando até que uma entrada válida seja fornecida.
	 *
	 * @param scanner Objeto Scanner para leitura da entrada do usuário
	 * @return Uma string representando um nome válido
	 */
	private static String obterNomeValido(Scanner scanner) {
		String nome;

		// Laço que continua pedindo o nome até ser válido
		while (true) {
			// Solicita ao usuário que digite seu nome
			System.out.print("Digite seu nome: ");
			nome = scanner.nextLine().trim(); // Remove espaços em branco antes e depois do nome

			// Verifica se o nome contém apenas letras e espaços
			if (nome.matches("[A-Za-zÀ-ÿ ]+")) {
				break; // Nome válido; sai do loop
			} else {
				// Informa ao usuário que o nome é inválido e solicita novamente
				System.out.println(MENSAGEM_NOME_INVALIDO);
			}
		}
		return nome;
	}

	/**
	 * Solicita ao usuário que insira uma temperatura válida em Fahrenheit. Continua
	 * solicitando até que uma entrada válida seja fornecida.
	 *
	 * @param scanner Objeto Scanner para leitura da entrada do usuário
	 * @return Um valor double representando a temperatura em Fahrenheit
	 */
	private static double obterTemperaturaValida(Scanner scanner) {
		double temperatura;

		// Laço que continua pedindo a temperatura até ser válida
		while (true) {
			// Solicita ao usuário que digite a temperatura em Fahrenheit
			System.out.print("Digite a temperatura em Fahrenheit: ");
			String entrada = scanner.nextLine();
			try {
				// Tenta converter a entrada para um valor double
				temperatura = Double.parseDouble(entrada);
				break; // Conversão bem-sucedida; sai do loop
			} catch (NumberFormatException e) {
				// Informa ao usuário que a entrada é inválida e solicita novamente
				System.out.println(MENSAGEM_ENTRADA_INVALIDA);
			}
		}
		return temperatura;
	}

	/**
	 * Converte a temperatura de Fahrenheit para Celsius
	 *
	 * @param fahrenheit temperatura em Fahrenheit
	 * @return temperatura convertida em Celsius
	 */
	private static double converterFahrenheitparaCelsius(double fahrenheit) {
		// Fórmula de conversão de Fahrenheit para Celsius
		return (fahrenheit - 32) * 5.0 / 9.0;
	}
}