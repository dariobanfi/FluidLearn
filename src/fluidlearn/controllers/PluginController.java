package fluidlearn.controllers;

import fluidlearn.plugin.Plugin;
import fluidlearn.plugin.PluginBook;
import fluidlearn.plugin.PluginDrive;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PluginController {

    private static Class[] plugins = {PluginDrive.class, PluginBook.class};

    public List<Plugin> getPlugins() {
        List<Plugin> l = new LinkedList<Plugin>();
        for (Class c : plugins) {
            try {
                l.add((Plugin) c.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
    public Plugin getPlugin(String id){
        Plugin p = null;
        for (Class c : plugins) {
            try {
                p = (Plugin)c.newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(p.getId().equals(id)){
                return p;
            }
        }
        return p;
    }
}
