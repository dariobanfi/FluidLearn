package fluidlearn.plugin;

import fluidlearn.corpo.Artefatto;

public class PluginBook implements Plugin {

    String id = "333";
    String nome = "Facebook Plugin";

    @Override
    public Artefatto creaArtefatto() {
        return new Artefatto(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome;
    }
}
