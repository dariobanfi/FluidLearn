package fluidlearn.plugin;

import fluidlearn.corpo.Artefatto;

public class PluginDrive implements Plugin {

    String id = "81680085";
    String nome = "GoogleDrive Plugin";

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
