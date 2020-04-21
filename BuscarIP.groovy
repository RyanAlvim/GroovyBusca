import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane
import groovy.json.JsonSlurper 
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

class BuscarIP{
    def Buscar(){

    def url = JOptionPane.showInputDialog("Digite o IP ");
        def obj = new URL("http://ip-api.com/json/${url}");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            def br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine = br.readLine();
            FileWriter jn = new FileWriter("dados.json")
            PrintWriter gravarjn = new PrintWriter(jn);
            gravarjn.printf("$inputLine")
            gravarjn.close()

            def jsonSlurper = new JsonSlurper()
            File file = new File("dados.json")
            def object = jsonSlurper.parse(file)

            if(object.status == "fail"){
                JOptionPane.showMessageDialog(null,"ERRO: IP NÃO EXISTE")
                return;
            }
        FileWriter result = new FileWriter("result.txt")
        PrintWriter gravarresult = new PrintWriter(result);
        gravarresult.printf("""
        =-=-=-=RESULT=-=-=-= 
        Status: $object.status
        País: $object.country
        Sigla do País: $object.countryCode
        Sigla da Região: $object.region
        Nome da Região: $object.regionName
        Cidade: $object.city
        Cep: $object.zip
        Latitude: $object.lat
        Longetude: $object.lon
        Timezone: $object.timezone
        Operadora: $object.isp
        IP: $object.query
        =-=-=-=RESULT=-=-=-= 
        """)
        gravarresult.close()
        
    JOptionPane.showMessageDialog(null, """
        Status: $object.status
        País: $object.country
        Sigla do País: $object.countryCode
        Sigla da Região: $object.region
        Nome da Região: $object.regionName
        Cidade: $object.city
        Cep: $object.zip
        Latitude: $object.lat
        Longetude: $object.lon
        Timezone: $object.timezone
        Operadora: $object.isp
        IP: $object.query
    """)
        }
    }
}