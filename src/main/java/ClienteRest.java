import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class ClienteRest {
    public ClienteRest ()
    {

    }

    public String listarPost (String usuario) {
        Client cliente = Client.create();
        WebResource recursos = cliente.resource("http://localhost:4567/rest/listadoPost/" + usuario);

        ClientResponse respuesta = recursos.accept("application/json").get(ClientResponse.class);

        String salida = respuesta.getEntity(String.class);
        return salida;
    }


}
