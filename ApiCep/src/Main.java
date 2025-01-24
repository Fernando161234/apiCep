import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import info.infoGerais;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import local.localJson;
import local.localNormal;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        infoGerais gerais = new infoGerais();
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        List<localNormal> localNormalList = new ArrayList<>();

        while(!gerais.isAtivo()) {
            System.out.println("Qual o seu cep?");
            gerais.setCep(scanner.nextLine());
            if (gerais.getCep().equalsIgnoreCase("sair")) {
                break;
            }

            if (gerais.getCep().length() != 8) {
                while(gerais.getCep().length() != 8) {
                    System.out.println("O cep deve conter exatamente 8 digitos");
                    Thread.sleep(250);
                    System.out.println("Digite seu cep novamente");
                    gerais.setCep(scanner.nextLine());
                }
            }

            gerais.setEndereco("https://viacep.com.br/ws/" + gerais.getCep() + "/json/");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(gerais.getEndereco()))
            .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String seuCep = response.body();
            localJson localCep = gson.fromJson(seuCep, localJson.class);
            localNormal resul = new localNormal(localCep);
            Thread.sleep(500);
            System.out.println(resul);
            Thread.sleep(250);
            localNormalList.add(resul);
        }

        FileWriter escrita = new FileWriter("Ceps.json");
        escrita.write(gson.toJson(localNormalList));
        escrita.close();
        System.out.println(escrita);
    }
}