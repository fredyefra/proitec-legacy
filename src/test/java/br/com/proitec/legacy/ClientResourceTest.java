package br.com.proitec.legacy;

import br.com.proitec.legacy.controller.ClienteResource;
import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;


public class ClientResourceTest {



    @Test
    public void deveTestarGet(){
        ClienteResource clienteResource = new ClienteResource();
        Assert.assertNotNull(clienteResource.findAll());
    }
}
