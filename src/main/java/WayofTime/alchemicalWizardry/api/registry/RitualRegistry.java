package WayofTime.alchemicalWizardry.api.registry;

import WayofTime.alchemicalWizardry.api.AlchemicalWizardryAPI;
import WayofTime.alchemicalWizardry.api.ritual.Ritual;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;

public class RitualRegistry {

    public static final BiMap<Ritual, Boolean> enabledRituals = HashBiMap.create();
    private static final BiMap<String, Ritual> registry = HashBiMap.create();

    /**
     * The safe way to register a new Ritual.
     *
     * @param ritual - The ritual to register.
     * @param id     - The ID for the ritual. Cannot be duplicated.
     */
    public static void registerRitual(Ritual ritual, String id) {
        if (ritual != null) {
            if (registry.containsKey(id))
                AlchemicalWizardryAPI.getLogger().error("Duplicate ritual id: " + id);
            else
                registry.put(id, ritual);
        }
    }

    public static Ritual getRitualForId(String id) {
        return registry.get(id);
    }

    public static String getIdForRitual(Ritual ritual) {
        return registry.inverse().get(ritual);
    }

    public static boolean isMapEmpty() {
        return registry.isEmpty();
    }

    public static int getMapSize() {
        return registry.size();
    }

    public static boolean ritualEnabled(Ritual ritual) {
        return enabledRituals.get(ritual);
    }

    public static BiMap<String, Ritual> getRegistry() {
        return HashBiMap.create(registry);
    }

    public static ArrayList<String> getIds() {
        return new ArrayList<String>(registry.keySet());
    }

    public static ArrayList<Ritual> getRituals() {
        return new ArrayList<Ritual>(registry.values());
    }
}
