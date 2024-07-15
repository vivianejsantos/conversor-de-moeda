public class Menu {
    private final ConversorDeMoeda conversor;

    public Menu(ConversorDeMoeda conversor) {
        this.conversor = conversor;
    }

    public void exibirMenu() {
        System.out.println("===== Conversor de Moedas =====");
        System.out.println("1. Dólar =>> Real");
        System.out.println("2. Real =>> Dólar");

        System.out.println("3. Euro =>> Real");
        System.out.println("4. Real =>> Euro");

        System.out.println("5. Euro =>> Dólar");
        System.out.println("6. Dólar =>> Euro");

        System.out.println("7. Real =>> Iene japonês");
        System.out.println("8. Iene japonês =>> Real");

        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {

            case 1:
                conversor.converterMoeda("USD", "BRL");
                break;
            case 2:
                conversor.converterMoeda("BRL", "USD");
                break;
            case 3:
                conversor.converterMoeda("EUR", "BRL");
                break;
            case 4:
                conversor.converterMoeda("BRL", "EUR");
                break;
            case 5:
                conversor.converterMoeda("EUR", "USD");
                break;
            case 6:
                conversor.converterMoeda("USD", "EUR");
                break;
            case 7:
                conversor.converterMoeda("BRL", "JPY");
                break;
            case 8:
                conversor.converterMoeda("JPY", "BRL");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
