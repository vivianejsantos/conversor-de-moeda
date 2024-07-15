import java.util.Scanner;

public class ConversorDeMoeda {
    private final ConsultaCotacao consultaCotacao;
    private CotacaoV6Exchangerate cotacaoV6Exchangerate;

    public ConversorDeMoeda(String apiKey) {
        this.consultaCotacao = new ConsultaCotacao(apiKey);
    }

    public void converterMoeda(String moedaDe, String moedaPara) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o valor em " + moedaDe + ": ");
            double valor = Double.parseDouble(scanner.nextLine());

            CotacaoV6Exchangerate taxa = consultaCotacao.obterTaxaDeCambio(moedaDe, moedaPara);
            double taxaDeCambio = Double.parseDouble(taxa.conversion_rate());
            double resultado = valor * taxaDeCambio;

            System.out.println("Valor em " + moedaPara + ": " + resultado + "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
