package fit.se;

import jakarta.inject.Inject;


public class Hello {

    @Inject
    private World world;

    public String helloWord(){
        return "hello " + world.wolrd();
    }
}
