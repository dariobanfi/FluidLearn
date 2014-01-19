package fluidlearn.plugin;

import fluidlearn.corpo.Artefatto;

public interface Plugin {
     public Artefatto creaArtefatto();
     public String getId();
    @Override
     public String toString();
}
