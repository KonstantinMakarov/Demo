package lombokentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class School {

    public String name;
    public String id;

    private List<Pupil> pupils;

    public List<Pupil> getPupils() {
        return pupils;
    }

    public static class Pupil {
        public String name;

    }

    public String getFieldValuseByName(String name) {
        try {
            return (String) getClass().getField(name).get(this);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return "";
    }
}
