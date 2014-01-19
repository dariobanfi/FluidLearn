package fluidlearn.corpo;

import java.util.Random;

public class Artefatto implements Corpo {

    private String id;
    private String pluginId;

    public Artefatto(String pluginId) {
        this.id=new Random().nextInt()+"";
        this.pluginId = pluginId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPluginId() {
        return pluginId;
    }

    public void setPluginId(String pluginId) {
        this.pluginId = pluginId;
    }

    @Override
    public String getTesto() {
        return "Artefatto " + id + ", creato con plugin " + pluginId;
    }
}
