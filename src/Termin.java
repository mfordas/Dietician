import java.io.Serializable;
import java.util.Date;

public class Termin implements Serializable {
    private String id;
    private String date;
    private String hour;

    public static class Builder {
        private String id;
        private String date;
        private String hour;


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder hour(String hour) {
            this.hour = hour;
            return this;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setHour(String hour) { this.hour = hour; }


        public Termin build() {
            return new Termin(this);
        }
    }

    private Termin(Builder builder) {
        this.date = builder.date;
        this.id = builder.id;
        this.hour = builder.hour;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }
}

