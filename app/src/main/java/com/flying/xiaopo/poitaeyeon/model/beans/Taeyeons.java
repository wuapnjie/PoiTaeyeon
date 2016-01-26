package com.flying.xiaopo.poitaeyeon.model.beans;

import java.util.List;

/**
 * Created by Flying SnowBean on 2016/1/26.
 */
public class Taeyeons {
    /**
     * date : 2016-01-16
     * description : null
     * id : 1
     * pic : /photos/fowYEBzeKj.png
     */

    private List<Taeyeon> taeyeon;

    public void setTaeyeon(List<Taeyeon> taeyeon) {
        this.taeyeon = taeyeon;
    }

    public List<Taeyeon> getTaeyeon() {
        return taeyeon;
    }

//    public static class Taeyeon {
//        private String date;
//        private String description;
//        private int id;
//        private String pic;
//
//        public void setDate(String date) {
//            this.date = date;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public void setPic(String pic) {
//            this.pic = pic;
//        }
//
//        public String getDate() {
//            return date;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public String getPic() {
//            return pic;
//        }
//    }
}
