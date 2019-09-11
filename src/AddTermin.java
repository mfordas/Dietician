import java.util.List;

public class AddTermin implements TerminOperation {
    @Override
    public void terminOperation(List<Termin> terminList, DieticianDatabase db) {
        do {
            TerminFactory.createTermin(db);

            System.out.println("Czy chcesz dodać kolejny termin? T/N");
        } while (readNextTermin().equalsIgnoreCase("t"));


    }

}
