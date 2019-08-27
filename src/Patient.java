import java.io.Serializable;

public class Patient implements Serializable {

    private String id;
    private String firstName;
    private String lastName;



    public static class Builder {

        private String id;
        private String firstName;
        private String lastName;
        private String Info;


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder Info(String Info) {
            System.out.println(Info);
            this.Info = Info;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }
    }



    private Patient(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;

    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Patient(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return
                id + ' ' +
                firstName + ' ' +
                lastName + ' '
                ;
    }
}
