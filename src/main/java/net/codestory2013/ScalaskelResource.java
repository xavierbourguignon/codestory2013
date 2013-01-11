package net.codestory2013;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ScalaskelResource extends ServerResource {

    @Get("json")
    public String change(String number) {
        return "{ \"Foo\": 1}";
    }
}
